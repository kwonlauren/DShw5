public class Key implements KeyInterface<String>{

    private static final int KEY_LENGTH = 6;
    private String key;//길이가 6인 string
    private int hash;

    public Key(String key){
        this.key = key;
        this.hash = hashFunc(key);
    }

    private static final int hashFunc(String key){
        int hash=0;
        for(int i=0; i<KEY_LENGTH; i++){
            hash += key.charAt(i);
        }
        return hash%100;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public int getHash() {
        return hash;
    }
}
