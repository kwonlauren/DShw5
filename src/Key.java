public class Key implements Comparable{
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
    public boolean equals(Object o){
        return key.equals(o);
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
    public int compareTo(Object o) {
        try{
            if(o.getClass() != this.getClass()){
                throw new UnsupportedOperationException();
            }
            Key o_key = (Key) o;
            return this.key.compareTo(o_key.key);
        } catch(UnsupportedOperationException e){
            System.err.println("Cannot compare Key to something else.");
            return -10;
        }
    }


}
