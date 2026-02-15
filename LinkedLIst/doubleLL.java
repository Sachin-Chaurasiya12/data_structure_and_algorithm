package LinkedLIst;
public class doubleLL {
    public class Node{
        private int data;
        private Node next;
        private Node prev;
        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
        public int getdata(){
            return data;
        }
        public void setdata(int data){
            this.data = data;
        }
        public Node getNext(){
            return next;
        }
        public void setNext(Node where){
            this.next = where;
        }
        public Node getprev(){
            return prev;
        }
        public void setprev(Node where){
            this.prev = where;
        }
    }
    private Node head;
    private Node tail;
    public void insertfirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
            return;
        }
        newNode.setNext(head);
        head.setprev(newNode);
        head = newNode;
    }
    public void insertlast(int data){
        Node newNode = new Node(data);
        Node current = head;
        if(head == null){
            head = newNode;
            tail = newNode;
            return;
        }
        tail.setNext(newNode);
        newNode.prev = tail;
        tail = newNode;
    }
    public void insert(int data, int position){
        Node newNode = new Node(data);
        Node current = head;
         if (position < 0 || position > length()) {
        return;
         }
        if(position == 0){
            insertfirst(data);
            return;
        }
        if(position == length()){
            insertlast(data);
            return;
        }

        for(int i=0;i < position - 1; i++){
            current = current.getNext();
        }
        newNode.setNext(current.next);
        newNode.setprev(current);

        current.next.setprev(newNode);
        current.setNext(newNode);
    }
    public void deletefirst(){
        if(head == null) return ;
        if(head == tail){
            head = tail = null;
            return;
        }
        head = head.next;
        head.prev = null;
    }
    public void deletelast(){
        if(tail == null) return ;
        if(head == tail) {
            head = tail = null;
            return;
        }
        tail = tail.prev;
        tail.next = null;
    }
    public void delete(int position){
        Node curNode = head;
        if(position < 0 || position > length()){
            return;
        }
        if(position == 0){
            deletefirst();
            return;
        }
        if(position == length() - 1){
            deletelast();
            return;
        }
        for(int i=0;i < position ; i++){
            curNode = curNode.next;
        }
        curNode.prev.next = curNode.next; 
        curNode.next.prev = curNode.prev;
    }
    public int length(){
        int length = 0;
        Node curNode = head;
        while(curNode != null){
            length++;
            curNode = curNode.next;
        }
        return length;
    }
    public boolean search(int data){
        Node curNode = head;
        if(head == null){
            return false;
        }
        if(head.getdata() == data){
            return true;
        }
        while(curNode.getNext() != null){
            if(curNode.next.getdata() == data){
                return true;
            }
            curNode = curNode.next;
        }
        return false;
    }
    public void displayfront(){
        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.getdata() + " --> ");
            currNode = currNode.getNext();
        }
        System.out.print("Null\n");
    }
    public void displayback(){
        Node currNode = tail;
        while(currNode != null){
            System.out.print(currNode.getdata() + " <-- ");
            currNode = currNode.getprev();
        }
        System.out.print("Null\n");
    }
    public static void main(String[] args) {
        doubleLL ll = new doubleLL();
        ll.insertfirst(1);
        ll.insertfirst(2);
        ll.insertfirst(3);
        ll.insertlast(4);
        ll.insert(8 , 2);
        ll.displayfront();
        ll.displayback();
        ll.deletefirst();
        ll.displayfront();
        ll.displayback();
        // ll.display();
        ll.deletelast();
        ll.displayfront();
        ll.displayback();
        // ll.display();
        // System.out.println(ll.length());
        ll.delete(2);
        ll.displayfront();
        ll.displayback();
        System.out.println(ll.length());
        System.out.println(ll.search(1));
    }
}
