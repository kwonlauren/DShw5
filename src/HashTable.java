public class HashTable <K extends Comparable<K>, V extends Printable>{
    private static final int SIZE = 100;
    private AVLTree<K, V> table[];
    public HashTable(){
         table = new AVLTree[100];
         for(int i=0; i<SIZE; i++) table[i] = null; //비어있는 AVL Tree 100개 만들기
    }

    public void insert(K key, V value){
        if(table[key.hashCode()] == null){
            table[key.hashCode()] = new AVLTree<>(key, value); //slot이 비어있으면 새로운 tree 생성
        }
        else{
            table[key.hashCode()].insert(key, value);//slot이 차있으면 기존 tree에 추가
        }
    }

    public void print(int index){
        if(table[index] != null) table[index].print();
        else System.out.println("EMPTY");
    }

    public LinkedList<V> search(K key){//길이 6인 str을 검색.
        if(table[key.hashCode()] != null) {//str에 해당하는 hash slot이 차있으면
            return table[key.hashCode()].search(key);
        }
        else return null;//없으면. 앞단계에서 (0,0) 출력해주기
    }
}
