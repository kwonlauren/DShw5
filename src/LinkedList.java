public class LinkedList <V>{
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

    public String toString(){
        if(numItems == 0){
            return null;
        }else{
            StringBuilder str = new StringBuilder();
            LLNode<V> curr = head.next;
            while(curr.next != null){
                str.append(curr.item.toString());
                str.append(" ");
                curr = curr.next;
            }//여기서 curr는 마지막 노드
            str.append(curr.item.toString());
            return str.toString();
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
