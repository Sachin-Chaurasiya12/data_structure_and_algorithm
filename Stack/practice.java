package Stack;
public class practice {
    //Linkedstack
    public class ListNode{
        private int data;
        private ListNode next;
        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }
    private int length;
    private ListNode top;
    public practice(){
        length = 0;
        top = null;
    }
    public int size(){
        return length;
    }
    public boolean isempty(){
        return (length==0);
    }
    public void push(int data){
        ListNode node = new ListNode(data);
        node.next = top;
        top = node;
        length++;
    }
    public int pop() throws Exception{
        if(isempty()) throw new Exception("stack is empty");
        int result = top.data;
        top = top.next;
        length--;
        return result;
    }
    public int peek() throws Exception{
        if(isempty()) throw new Exception("stack is empty");
        return top.data;
    }
    public static void main(String[] args) {
        practice p = new practice();
        try {
            for(int i=1;i<15;i++){
            p.push(i);
        }
        System.out.println(p.toString());
        System.out.println(p.pop());
        System.out.println(p.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}