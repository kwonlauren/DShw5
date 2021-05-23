public class LinkedList <V extends Printable>{
    private LLNode<V> head;
    private int numItems;

    public LinkedList(){
        numItems = 0;
        head = new LLNode<V>(null, null);//Dummy Head
    }

    public void append(V x){
        LLNode<V> prev = head;
        while(prev.next != null) prev = prev.next;
        LLNode<V> newNode = new LLNode<>(x);
        prev.next = newNode;
        numItems++;
    }

    public void printList(){
        LLNode<V> curr = head.next;
        while(curr.next != null){
            curr.item.print();
            System.out.print(" ");
            curr = curr.next;
        }//여기서 curr는 마지막 노드
        curr.item.print();
    }

}
