public class test {
    public static void main(String args[]){
        HashTable<Key, Pair> ht = new HashTable<>();
        Key k1 = new Key("abcdef");
        Key k2 = new Key("defabc");
        Key k3 = new Key("abcddd");
        Pair p1 = new Pair(3,8);
        Pair p2 = new Pair(4,1);
        Pair p3 = new Pair(4,8);
        ht.insert(k1, p1);
        ht.insert(k2, p2);
        ht.insert(k3, p3);
        System.out.println(k1.hashCode());
        System.out.println(k2.hashCode());
        ht.print(97);
    }
}
