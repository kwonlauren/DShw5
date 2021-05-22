public interface IndexInterface <K, V, T> {
    public void insert(K key, T item);
    public V search(K key);
}
