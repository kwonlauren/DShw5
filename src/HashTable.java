public class HashTable <K extends KeyInterface, V extends ListInterface, C extends IndexInterface<K,V,T>, T> implements IndexInterface<K, V, C, T>{
    /* 수업자료 Hash code 참고함. */

    private C table[];
    int numItems;

    public HashTable(int size){
        table = (C[]) new Object[size];
        numItems = 0;
    }

    @Override
    public void insert(K key, T item) {
        //AVL tree에 key, item을 append
        C chain = table[key.getHash()];
        chain.insert(key, item);
        C cc = new C();
    }

    @Override
    public V search(K key) {
        //key에 해당하는 Linked List return
        C chain = table[key.getHash()];//AVLtree
        return chain.search(key);
    }

    public C getChain(int hash) {
        return null;
    }
}
