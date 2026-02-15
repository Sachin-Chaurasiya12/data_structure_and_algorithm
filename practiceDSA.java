public class practiceDSA {
    protected int capacity;
    public static final int CAPACITY=10;
    protected int[] stackrep;
    protected int top = -1;

    public practiceDSA(){
        this(CAPACITY);
    }
    public practiceDSA(int cap) {
        capacity = cap;
        stackrep = new int[capacity];
    }
    public int size(){
        return top + 1;
    }
    public boolean isempty(){
        return top < 1;
    }
    public void push(int data){
        if(size() == capacity) extend();
        stackrep[++top] = data;
    }
    public void extend(){
        int length = size();
        int[] newstack = new int[length << 1];
        System.arraycopy(stackrep,0,newstack,0,size());
        stackrep = newstack;
        this.capacity = this.capacity << 1;
    }
    public void pop() throws Exception{
        if(isempty()) throw new RuntimeException("stack is empty");
        stackrep[top--] = Integer.MIN_VALUE;
        shrink();
    }
    public void shrink(){
        if(size() <= capacity){
            return;
        }
        if(size() <= capacity >> 2){
            int newcapacity = capacity >> 1;
            if(capacity <= newcapacity){
                capacity = newcapacity;
            }
            int[] newstack = new int[capacity];
            System.arraycopy(stackrep, 0, newstack, 0, size());
            stackrep = newstack;
            this.capacity = newcapacity;
        }
    }
    public int peek() throws Exception{
        if(isempty()) throw new RuntimeException("stack is empty");
        return stackrep[top];
    }
    public String toString(){
        String s;
        s = "[";
        if(size() > 0) s += stackrep[0];
        if(size() > 1){
            for(int i=1;i<size();i++){
                s += "|" + stackrep[i];
            }
        }
        return s += "]";
    }
    public static void main(String[] args) {
        practiceDSA ll = new practiceDSA();
        for(int i=1;i<20;i++){
            ll.push(i);
        }
        System.out.println(ll.toString());
    }
}
