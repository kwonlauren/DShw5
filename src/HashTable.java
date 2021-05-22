public class HashTable <K extends KeyInterface, V, C, T> implements HTIneterface<K, V, C, T>{
    /* 수업자료 Hash code 참고함. */

    private int table[];
    int numItems;

    public HashTable(int size){
        table = new int[size];
        numItems = 0;
    }

    @Override
    public void put(K key, T value) {

    }
}
