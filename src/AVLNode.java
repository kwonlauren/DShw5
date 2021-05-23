public class AVLNode <K, V extends Printable>{
    public K key;
    public LinkedList<V> item;
    public AVLNode<K, V> left, right;
    public int height;
    public AVLNode(K key, V value, AVLNode<K, V> leftChild, AVLNode<K, V> rightChild){//key가 처음 들어왔을 때 새로운 노드 생성.
        this.key = key;
        item = new LinkedList<>();
        item.append(value);
        left = leftChild;//직접 NIL로 넣어주기
        right = rightChild;
        height = 1;
    }
    public AVLNode(int h){//NIL 만들때만 사용.
        try{
            if(h != 0) throw new IllegalArgumentException();
            key = null;
            item = null;
            left = right = null;
            height = h;
        }
        catch (IllegalStateException e){
            System.err.println("NIL 생성시에만 사용가능");
        }
    }
}