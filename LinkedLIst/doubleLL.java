package LinkedLIst;

public class doubleLL {
    public class DLLNode{
        private int data;
        private DLLNode prev;
        private DLLNode next;
        public DLLNode(int data,DLLNode prev,DLLNode next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
        public void setData(int data){
            this.data = data;
        }
        public int getData(){
            return data;
        }
        public void setPrev(DLLNode where){
            prev = where;
        }
        public void setNext(DLLNode where){
            next = where;
        }
        public DLLNode getPrev(){
            return prev;
        }
        public DLLNode getNext(){
            return next;
        }
    }
    private DLLNode head;
    private DLLNode tail;
    public void insertfirst(int data){
        DLLNode newNode = new DLLNode(data, null, head);
        if(head == null){
            head = newNode;
            tail = newNode;
            return;
        }
        head.setPrev(newNode);
        head = newNode;
    }
    public void insertlast(int data){
        DLLNode newNode = new DLLNode(data, tail, null);
        if(head == null){
            head = newNode;
            tail = newNode;
            return;
        }
        DLLNode currNode = head;
        while(currNode.next != null){
            currNode = currNode.next;
        }
        tail.setNext(newNode);
        tail = newNode;
    }
    public void Treverseback(){
        DLLNode currNode = tail;
        while(currNode != null){
            System.out.print(currNode.getData() + " <--");
            currNode = currNode.getPrev();
        }
        System.out.println("null");
    }
    public void Treverseforth(){
        DLLNode currNode = head;
        while(currNode != null){
            System.out.print(currNode.getData() + " --> ");
            currNode = currNode.getNext();
        }
        System.out.print("null");
    }
    public static void main(String[] args) {
        doubleLL LL = new doubleLL();
        LL.insertfirst(1);
        LL.insertlast(0);
        LL.insertlast(-0);
        LL.Treverseback();
        LL.Treverseforth();
    }
}
