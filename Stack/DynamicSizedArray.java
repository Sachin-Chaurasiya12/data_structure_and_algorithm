package Stack;

public class DynamicSizedArray {
    protected int capacity;
    public static final int CAPACITY=5;
    protected int[] stackrep;
    protected int top = -1;

    public DynamicSizedArray(){
        this(CAPACITY);
    }
    public DynamicSizedArray(int cap){
        capacity = cap;
        stackrep = new int[capacity];
    }
    public int size(){
        return top + 1;
    }
    public boolean isempty(){
        return top < 0;
    }
    public void push(int data){
        if(size() == capacity) expand();
        stackrep[++top] = data;
    }
    public void expand(){
        int length = size();
        int[] newstack = new int[length << 1];
        System.arraycopy(stackrep, 0, newstack, 0, length);
        stackrep = newstack;
        this.capacity = this.capacity << 1;
    }
    private void shrink(){
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
    public int pop() throws Exception{
        int data;
        if(isempty()) throw new Exception("stack is empty");
        data = stackrep[top];
        stackrep[top--] = Integer.MIN_VALUE;
        shrink();
        return data;
    }
    public int top() throws Exception{
        if(isempty()) throw new Exception("stack is empty");
        return stackrep[top];
    }
    public String toString(){
        String s = "[";
        if(size() > 0) s += stackrep[0];
        if(size() > 1){
            for(int i=1;i<size();i++){
                s += "|" + stackrep[i];
            }
        }
        return s + "]";
    }
    public static void main(String[] args) {
        DynamicSizedArray stack = new DynamicSizedArray();
        try {
            for(int i=1;i<20;i++){
                stack.push(i);
            }
            System.out.println(stack.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
