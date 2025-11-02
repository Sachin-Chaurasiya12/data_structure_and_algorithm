package LinkedLIst;
public class singleLL{
    public class ListNode{
        private int data;
        private ListNode next;
        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
        public void setData(int data){
            this.data = data;
        }
        public int getData(){
            return data;
        }
        public void setNext(ListNode next){
            this.next = next;
        }
        public ListNode getNext(){
            return this.next;
        }
    }
    //inserting data
    //insert data in the beginning
    private ListNode head;
    public void insert(int data){
        ListNode newNode = new ListNode(data);
        if(head == null){
            head = newNode;
            return;
        }
        ListNode CurrentNode = head;
        newNode.setNext(CurrentNode);
        head = newNode;
    }
    //inserting at the end
    public void insertEnd(int data){
        ListNode newNode = new ListNode(data);
        if(head == null){
            head = newNode;
            return;
        }
        ListNode CurrentNode = head;
        while(CurrentNode.getNext() != null){
            CurrentNode = CurrentNode.next;
        }
        CurrentNode.setNext(newNode);
    }
    //inserting at specified position
    public void insertMiddle(int data,int position){
        ListNode newNode = new ListNode(data);
        if(position <= 0){
            insert(data);
            return;
        }
        if(position >= length()){
            insertEnd(data);
            return;
        }
        if(head == null){
            head = newNode;
            return;
        }
        ListNode CurrentNode = head;
        for(int i=0; i<position-1;i++){
            CurrentNode = CurrentNode.next;
        }
        newNode.next = CurrentNode.next;
        CurrentNode.next = newNode;
    }
    //treversing in linked list.
    public int length(){
        int length = 0;
        ListNode CurrentNode = head;
        while(CurrentNode != null){
            length++;
            CurrentNode = CurrentNode.next;
        }
        return length;
    }
    //deleting in a Linked List
    //delete the first node.
    public void deletefirst(){
        if(head == null){
            return;
        }
        ListNode temp = head;
        head = head.next;
        temp = null;
    }
    //delete the last node.
    public void deletelast(){
        if(head == null){
            return;
        }
        if(head.next == null){
            head = null;
            return;
        }
        ListNode prev = null;
        ListNode tail = head;
        while(tail.next != null){
            prev = tail;
            tail = tail.next;
        }
        prev.next = null;
        tail = null;
    }
    //deleting from spectified position.
    public void delete(int data){
        // ListNode node = new ListNode(data);
        if(head == null){
            return;
        }
        if(head.data == data){
            head = head.next;
            return;
        }
        ListNode tail = head.next;
        ListNode prev = head;
        while(tail != null){
            if(tail.data == data){
                prev.next = tail.next;
                tail = null;
                return;
            }
            prev = tail; 
            tail = tail.next;
        }
    }
    public void display(){
        ListNode CurrentNode = head;
        while(CurrentNode != null){
            System.out.print(CurrentNode.getData() + " --> ");
            CurrentNode = CurrentNode.getNext();
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        singleLL LL = new singleLL();
        LL.insert(1);
        LL.insertEnd(2);
        LL.insertEnd(4);
        LL.insertEnd(5);
        LL.insertMiddle(3, 2);
        // LL.deletefirst();
        // LL.deletelast();
        LL.delete(2);
        LL.display();
        System.out.println(LL.length());
    }
}