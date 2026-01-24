
import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minstack;

    public MinStack() {
        stack=new Stack<>();
        minstack=new Stack<>();
    }
     public void push(int val){
        stack.push(val);
        if(minstack.isEmpty() || val<=minstack.peek()){
            minstack.push(val);
        }
     }  
     public void pop(){
        if(!stack.isEmpty()){
            if(stack.peek().equals(minstack.peek())){
                minstack.pop();
            }
            stack.pop();
        }
     }
     public int top(){
        return stack.peek();
     }
     public int getMin(){
        return minstack.peek();
     }
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(3);
        minStack.pop();
        minStack.push(4);
        minStack.push(-1);
        minStack.top();
        minStack.push(6);
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
        System.out.println("Current Min: " + minStack.getMin()); 
    }
}