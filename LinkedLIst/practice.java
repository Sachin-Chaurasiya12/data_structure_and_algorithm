package LinkedLIst;
public class practice{
    public class DLLNode{
        private int data;
        private DLLNode prev;
        private DLLNode next;
        public DLLNode(int data,DLLNode prev,DLLNode next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
        public void setdata(int data){
            this.data = data;
        }
        public int getdata(){
            return data;
        }
        public void setprev(DLLNode where){
            prev = where;
        }
        public DLLNode getprev(){
            return prev;
        }
        public void setNext(DLLNode where){
            next = where;
        }
        public DLLNode getNext(){
            return next;
        }
        
    }
    private DLLNode head;
    private DLLNode tail;
    private int size = 0;
    //inserting 
    public void insertfirst(int data){
        DLLNode newNode = new DLLNode(data, null, head);
        if(head == null){
            head = newNode;
            tail = newNode;
            return;
        }
        head.setprev(newNode);
        head = newNode;
        size++;
    }
    public void insertlast(int data){
        DLLNode newNode = new DLLNode(data, tail, null);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        tail.setNext(newNode);
        tail = newNode;
        size++;
    }
    public void insert(int data,int position){
        DLLNode newnode = new DLLNode(data, null, null);
        DLLNode currNode = head;
        if(head == null){
            head = newnode;
            tail = newnode;
            size++;
            return;
        }
        if(position <= 0){
            insertfirst(data);
            size++;
            return;
        }
        if(position >= size()){
            insertlast(data);
            size++;
            return;
        }
        for(int i=0;i<position - 1;i++){
            currNode = currNode.next;
        }
        newnode.next = currNode.next;
        newnode.prev = currNode;
        currNode.next.setprev(newnode);
        currNode.setNext(newnode);
        size++;
    }
    //Treversing
    public void Treverseforth(){
        DLLNode currNode = head;
        while(currNode != null){
            System.out.print(currNode.getdata() + " --> ");
            currNode = currNode.getNext();
        }
        System.out.println("null");
    }
    public void Treverseback(){
        DLLNode currNode = tail;
        while(currNode != null){
            System.out.print(currNode.getdata() + " <-- ");
            currNode = currNode.getprev();
        }
        System.out.println("null");
    }
    public int size(){
        return size;
    }
    public int count(int data){
        int count = 0;
        DLLNode currNode = head;
        while(currNode != null){
            if(currNode.getdata() == data){
                count++;
            }
            currNode = currNode.next;
        }
        return count;
    }
    public void deletefirst(){
        if(head==null){
            return;
        }
        if(head.next == null){
            head = null;
            tail = null;
            return;
        }
        DLLNode temp = head;
        head = head.next;
        head.setprev(null);
        temp.setNext(null);
        size--;
    }
    public void deletelast(){
        if(head == null){
            return;
        }
        if(head.next == null){
            head = null;
            tail = null;
            return;
        }
        DLLNode temp = tail;
        tail = tail.getprev();
        tail.setNext(null);
        temp.setprev(null);
        size--;
    }
    public void delete(int position){
        if(head == null){
            return;
        }
        if(position <= 0){
            deletefirst();
            size--;
            return;
        }
        if(position >= size()){
            deletelast();
            size--;
            return;
        }
        DLLNode currNode = head;
        for(int i=0;i<position-1;i++){
            currNode = currNode.next;
        }
        DLLNode prevnode = currNode.getprev();
        DLLNode nextnode = currNode.getNext();

        prevnode.setNext(nextnode);
        nextnode.setprev(prevnode);

        currNode.setNext(null);
        currNode.setprev(null);

        size--;
    }
    public static void main(String[] args) {
        practice p = new practice();
        p.insertfirst(1);
        p.insertfirst(2);
        p.insertlast(2);
        p.insertlast(7);
        p.insert(4, 4);
        p.Treverseforth();
        p.deletefirst();
        p.Treverseforth();
        p.deletelast();
        p.Treverseforth();
        p.delete(3);
        p.Treverseforth();
        System.err.println(p.size());
        System.out.println(p.count(2));
    }
}