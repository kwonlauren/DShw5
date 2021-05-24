public class test {
    public static void main(String args[]){
        HashTable<Key, Pair> ht = new HashTable<>();
        Key k1 = new Key("abcdef");
        Key k2 = new Key("defabc");
        Key k3 = new Key("abcddd");
        Key k4 = new Key("abcdef");
        Pair p1 = new Pair(3,8);
        Pair p2 = new Pair(4,1);
        Pair p3 = new Pair(4,8);
        Pair p4 = new Pair(5,8);
        ht.insert(k1, p1);
        ht.insert(k2, p2);
        ht.insert(k3, p3);
        ht.insert(k4, p4);
        ht.print(97);
    }

    private static LinkedList<Pair> compareLL(LinkedList<Pair> LL1, LinkedList<Pair> LL2, int interval){
        // LL1, LL2에서 interval만큼 떨어진 연속한 pair를 찾아 새로운 LL로 만들고, 리턴한다.
        LinkedList<Pair> result = new LinkedList<Pair>();
        LLNode<Pair> Node1 = LL1.head;
        LLNode<Pair> Node2 = LL2.head;
        while(Node1 != null && Node2 != null){
            if(Node2.item.a < Node1.item.a) Node2 = Node2.next;
            else if(Node2.item.a > Node1.item.a) Node1 = Node1.next;
            else{//Node2.item.a == Node1.item.a
                if(Node2.item.b < Node1.item.b + interval) Node2 = Node2.next;
                else if(Node2.item.b > Node1.item.b + interval) Node1 = Node1.next;
                else{ //Node2.item.b == Node1.item.b + 6
                    result.append(Node1.item);
                    Node1 = Node1.next;
                    Node2 = Node2.next;
                }
            }
        }
        return result;
    }
}
