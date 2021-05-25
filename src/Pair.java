public class Pair implements Printable{
    public int a;
    public int b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }


    public void print(){
        System.out.printf("(%d, %d)",a,b);
    }

    public String toString(){
        return String.format("(%d, %d)", a, b);
    }
}
