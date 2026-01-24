
import java.util.Stack;

public class StackPermutation {
    public static boolean isStackPermutation(int[] orginal,int[] target){
        Stack<Integer> stack=new Stack<>();
        int i=0;
        for(int element:orginal){
            stack.push(element);
            while(!stack.isEmpty() && stack.peek()==target[i]){
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        int[] original = {1, 2, 3};
        int[] target   = { 1, 3,2};
        System.out.println(isStackPermutation(original, target));
    }
}