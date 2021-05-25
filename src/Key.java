public class Key implements Comparable<Key>{
    public String key;//length mush be 6
    private static final int KEY_LENGTH = 6;

    public Key(String key) {
        try{
            if(key.length()!=6) throw new IllegalArgumentException();
            this.key = key;
        }catch(IllegalArgumentException e){
            System.err.println("key is too long.");
        }
    }

    public String toString(){
        return key;
    }

    @Override
    public int hashCode(){
        int h=0;
        for(int i=0; i<KEY_LENGTH; i++){
            h += this.key.charAt(i);
        }
        return h%100;
    }

    @Override
    public int compareTo(Key anotherKey) {
        return this.key.compareTo(anotherKey.key);
    }


}
