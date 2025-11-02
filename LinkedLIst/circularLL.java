public class circularLL {
    public class Listnode{
        private int data;
        private Listnode next;
        public Listnode(int data){
            this.data = data;
        }
        public void setdata(int data){
            this.data = data;
        }
        public int getdata(){
            return data;
        }
        public void setNext(Listnode next){
            this.next=next;
        }
        public Listnode getNext(){
            return next;
        }
    }
    private Listnode head;
    public int length(){
        int length=0;
        if(head == null) return 0;
        Listnode CurrentNode = head;
        do{
            length++;
            CurrentNode = CurrentNode.next;
        }while(CurrentNode != head);
        System.out.print("length : ");
        return length;
    }
    public void insertlast(int data){
        Listnode newNode = new Listnode(data);
        if(head == null){
            head = newNode;
            head.next = head;
            return;
        }
        Listnode CurrentNode = head;
        do{
            CurrentNode = CurrentNode.next;
        }while(CurrentNode.next != head);
        CurrentNode.setNext(newNode);
        newNode.setNext(head);
    }
    public void insertfirst(int data){
        Listnode newNode = new Listnode(data);
        if(head == null){
            head = newNode;
            head.next = head;
            return;
        }
        Listnode CurrentNode = head;
        do{
            CurrentNode = CurrentNode.next;
        }while(CurrentNode.next != head);

        newNode.next = head;
        CurrentNode.setNext(newNode);
        head = newNode;
    }
    public void display(){
        Listnode CurrentNode = head;
        if(head == null){
            System.out.print("list is empty");
            return;
        }
        do{
            System.out.print(CurrentNode.getdata() + " --> ");
            CurrentNode = CurrentNode.next;
        }while(CurrentNode != head);
        System.out.println("back to head");
    }
    public void insert(int data,int position){
        Listnode newNode = new Listnode(data);
        if(head == null){
            head = newNode;
            head.next = head;
            return;
        }
        if(position <= 0){
            insertfirst(data);
            return;
        }
        if(position >= length()){
            insertlast(data);
            return;
        }
        Listnode CurrentNode = head;
        for(int i=1;i<position - 1 && CurrentNode.next != head ;i++){
            CurrentNode = CurrentNode.next;
        }
        Listnode temp = CurrentNode.next;
        CurrentNode.next = newNode;
        newNode.next = temp;
    }
    public static void main(String[] args) {
        circularLL ll = new circularLL();
        ll.insertlast(1);
        ll.insertlast(2);
        ll.insertlast(3);
        ll.insertlast(4);
        ll.insertfirst(5);
        ll.insert(7, 2);
        ll.display();
        System.out.println(ll.length());
    }
}
