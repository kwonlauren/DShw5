public class LinkedList <V extends Printable>{
    public LLNode<V> head;
    public int numItems;

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

    // search
    // delete

    public void print(){
        if(numItems==0){
            //TODO
        }else{
            LLNode<V> curr = head.next;
            while(curr.next != null){
                curr.item.print();
                System.out.print(" ");
                curr = curr.next;
            }//여기서 curr는 마지막 노드
            curr.item.print();
            System.out.println("");
        }
    }

    public LinkedList<V> shallowCopy(){
        //V는 그대로 가져오는 shallow copy
        LinkedList<V> newLL = new LinkedList<>();
        LLNode<V> node = this.head.next;
        while(node != null){
            newLL.append(node.item);
            node = node.next;
        }
        return newLL;
    }

}
