package Stack;

public class LinkedStack {
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
    public LinkedStack(){
        length = 0;
        top = null;
    }
    public void push(int data){
        ListNode node = new ListNode(data);
        node.next = top;
        top = node;
        length++;
    }
    public boolean isempty(){
        return (length==0);
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
        int result = top.data;
        return result;
    }
    public int size(){
        return length;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        ListNode curnode = top;
        while(curnode != null){
            sb.append(curnode.data);
            if(curnode.next != null){
                sb.append("|");
            }
            curnode = curnode.next;
        }
        return sb.toString() + "]";
    }
    public static void main(String[] args) {
        LinkedStack s = new LinkedStack();
        for(int i=1;i<10000;i++){
            s.push(i);
        }
        System.out.println(s.toString());
        try {
            s.pop();
            System.out.println(s.toString());
            System.out.println(s.peek());
            System.out.println(s.length);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    
    }
}
