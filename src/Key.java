public class Key extends Comparable<Key>{
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
    public int compareTo(Key o) {
        return this.key.compareTo(o.key);
    }
}
