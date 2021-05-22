public interface HTIneterface <K, V, C, T> {
    public void put(K key, T value);
    public C getChain(int hash);
    public V getValue(K key);
}
