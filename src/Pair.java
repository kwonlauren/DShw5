public class Pair{
    public int a;
    public int b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public String toString(){
        return String.format("(%d, %d)", a, b);
    }
}
