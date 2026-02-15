package Stack;

public class FixedSizeArrayStack {
    //Length of the array used to implement stack
    protected int capacity;
    //default array capacity
    public static final int CAPACITY=10;
    //array used to implement the stack
    protected int[] stackrep;
    //Index of the top element in the stack
    protected int top = -1;
    //initialize the stack to use an array of default length.
    public FixedSizeArrayStack(){
        this(CAPACITY);
    }
    //initialise the stack to use an array of given length.
    public FixedSizeArrayStack(int cap){
        capacity = cap;
        stackrep = new int[capacity];
    }
    //returns the number of element of the stack.
    public int size(){
        return top + 1;
    }
    //returns if the stack is empty.
    public boolean isempty(){
        return top < 0;
    }
    //adds element in the stack.
    public void push(int data) throws Exception{
        if(size() == capacity) throw new Exception("Stack is full");
        stackrep[++top] = data;
    }
    //return the top element of the stack without removing it.
    public int top() throws Exception{
        if(isempty()) throw new Exception("Stack is empty");
        return stackrep[top];
    }
    //remove the top element of the stack.
    public int pop() throws Exception{
        if(isempty()) throw new Exception("Stack is empty");
        return stackrep[top--];
    }
    //helps to display the stack
    public String toString(){
        String s;
        s = "[";
        if(size() > 0) s += stackrep[0];
        if(size() > 1) {
            for(int i=1;i<= size() - 1; i++){
                s += "|" + stackrep[i];
            }
        }
        return s + "]";
    }
    public static void main(String[] args) {
        FixedSizeArrayStack stack = new FixedSizeArrayStack(6);
        try {
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
            stack.push(5);
            stack.push(6);
            System.out.println(stack.toString());
            System.out.println(stack.size());
            System.out.println(stack.isempty());
            stack.pop();
            System.out.println(stack.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
