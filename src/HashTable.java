import java.lang.reflect.Array;
import java.util.ArrayList;

public class HashTable <K extends Comparable<K>, V>{
    private static final int SIZE = 100;
    ArrayList<AVLTree<K, V>> table;
    public HashTable(){
        table = new ArrayList<>(100);
        for(int i=0; i<SIZE; i++) table.add(null); //비어있는 AVL Tree 100개 만들기
    }

    public void insert(K key, V value){
        if(table.get(key.hashCode()) == null){
            table.set(key.hashCode(), new AVLTree<>(key, value)); //slot이 비어있으면 새로운 tree 생성
        }
        else{
            table.get(key.hashCode()).insert(key, value);//slot이 차있으면 기존 tree에 추가
        }
    }

    public String toString(int index){
        AVLTree<K, V> tree = table.get(index);
        if(tree != null && tree.toString() != null) {
            return tree.toString();
        }else return null;
    }

    public LinkedList<V> search(K key){//길이 6인 str을 검색.
        if(table.get(key.hashCode()) != null) {//str에 해당하는 hash slot이 차있으면
            return table.get(key.hashCode()).search(key);
        }
        else return null;//없으면. 앞단계에서 (0,0) 출력해주기
    }
}
