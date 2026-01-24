
import java.util.Stack;

public class StockSpan {
    public static void spanbrute(int[] stockPrices){
        int n=stockPrices.length;
        int[] span=new int[n];
        span[0]=1;
        for(int i=1;i<n;i++){
            span[i]=1;
            int j=i-1;
            while(j>=0 && stockPrices[i]>=stockPrices[j]){
                span[i]++;
                j--;
            }
        }
        for(int i=0;i<n;i++){
            System.out.println(span[i]+" ");
        }
    }
    public static void stockspan(int[] stockPrices){
        int n=stockPrices.length;
        int[] span=new int[n];
        Stack<Integer> stack=new Stack<>();
        span[0]=1;
        stack.push(0);
        for(int i=1;i<n;i++){
            while(!stack.isEmpty() && stockPrices[i]>=stockPrices[stack.peek()]){
                stack.pop();
            }
            span[i]=stack.isEmpty()?i+1:i-stack.peek();
            stack.push(i);
        }
        for(int i=0;i<n;i++){
            System.out.println(span[i]+" ");
        }
    }
    public static void main(String[] args) {
       
        int[] stockPrices = {100, 80, 60, 70, 60, 75, 85};
        spanbrute(stockPrices);
        stockspan(stockPrices);
    }
}