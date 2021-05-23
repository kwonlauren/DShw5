public class LLNode <V extends Printable> {
    //강의자료 Linked list 참고함.
    public V item;
    public LLNode<V> next;

    public LLNode(V newitem){
        item = newitem;
        next = null;
    }

    public LLNode(V newitem, LLNode<V> nextNode){
        item = newitem;
        next = nextNode;
    }
}
