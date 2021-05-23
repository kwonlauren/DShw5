public class AVLTree <K extends Comparable, V extends Printable> implements Printable{
    //강의자료 AVLTree 참고.
    private AVLNode<K,V> root;
    final AVLNode<K,V> NIL = new AVLNode<>(0);

    public AVLTree(K key, V value){
        root = NIL;
        insert(key, value);
    }

    public boolean isEmpty(){
        return root == NIL;
    }

    public void insert(K key, V value){
        root = insertItem(root, key, value);
    }

    private AVLNode insertItem(AVLNode tNode, K key, V value){
        int type;
        if(tNode == NIL){
            tNode = new AVLNode(key, value, NIL, NIL);
        } else if(key.compareTo(tNode.key)<0){// left branch
            tNode.left = insertItem(tNode.left, key, value);
            tNode.height = 1 + Math.max(tNode.right.height, tNode.left.height);
            type = needBalance(tNode);
            if(type != NO_NEED) tNode = balanceAVL(tNode, type);
        } else{// right branch
            tNode.right = insertItem(tNode.right, key, value);
            tNode.height = 1 + Math.max(tNode.right.height, tNode.left.height);
            type = needBalance(tNode);
            if(type != NO_NEED) tNode = balanceAVL(tNode, type);
        }
        return tNode;
    }

    public LinkedList<V> search(K key){
        AVLNode n = searchItem(root, key);
        if(n == NIL) return null;
        else return n.item;
    }

    private AVLNode searchItem(AVLNode tNode, K key){
        if(tNode == NIL) return NIL;
        else if(key.compareTo(tNode.key) == 0) return tNode;
        else if(key.compareTo(tNode.key) < 0) return searchItem(tNode.left, key);
        else return searchItem(tNode.right, key);
    }

    public void print(){
        if(root == NIL) System.out.println("EMPTY");
        else{
            printItem(root);
        }
        //TODO: 전위순회로 문자열 출력, 없을 경우 EMPTY
    }

    private void printItem(AVLNode tNode){
        if(tNode == root){
            System.out.printf("%s", tNode.key.toString());
            printItem(tNode.left);
            printItem(tNode.right);
        }else if(tNode != NIL){
            System.out.printf(" %s", tNode.key.toString());
            printItem(tNode.left);
            printItem(tNode.right);
        }//tNode == NIL 이면 아무것도 안하기
    }

    private final int LL=1, LR=2, RR=3, RL=4, NO_NEED=0, ILLEGAL=-1;

    private int needBalance(AVLNode t){
        int type = ILLEGAL;
                if(t.left.height+1 < t.right.height){//type R
            if(t.right.left.height <= t.right.right.height) type = RR;
            else type = RL;
        } else if (t.left.height > t.left.right.height+1){//type L
            if(t.left.left.height >= t.left.right.height) type = LL;
            else type = LR;
        } else type = NO_NEED;
        return type;

    }

    private AVLNode balanceAVL(AVLNode tNode, int type){
        AVLNode returnNode = NIL;
        switch (type){
            case LL:
                returnNode = rightRotate(tNode);
                break;
            case LR:
                tNode.left = leftRotate(tNode.left);
                returnNode = rightRotate(tNode);
                break;
            case RR:
                returnNode = leftRotate(tNode);
                break;
            case RL:
                tNode.right = rightRotate(tNode.right);
                returnNode = leftRotate(tNode);
                break;
            default:
                System.out.println("Impossible type.");
                break;
        }
        return returnNode;
    }

    private AVLNode leftRotate(AVLNode t){
        AVLNode RChild = t.right;
        if(RChild == NIL) System.out.println("t's RChild shouldn't be NIL");
        AVLNode RLChild = RChild.left;
        RChild.left = t;
        t.right = RLChild;
        t.height = 1+ Math.max(t.left.height, t.right.height);
        RChild.height = 1 + Math.max(RChild.left.height, RChild.right.height);
        return RChild;
    }

    private AVLNode rightRotate(AVLNode t){
        AVLNode LChild = t.left;
        if(LChild == NIL) System.out.println("t's LChild shouldn't be NIL");
        AVLNode LRChild = LChild.right;
        LChild.right = t;
        t.left = LRChild;
        t.height = 1+ Math.max(t.left.height, t.right.height);
        LChild.height = 1 + Math.max(LChild.left.height, LChild.right.height);
        return LChild;
    }


}

