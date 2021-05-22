public interface KeyInterface<KV>{
    //comparable / hashable
    public KV getKey();
    public int getHash();
}