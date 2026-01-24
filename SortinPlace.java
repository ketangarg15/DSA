import java.util.*;
public class SortinPlace {
    public static void sortQueue(Queue<Integer> queue){
        int n=queue.size();
        for(int i=0;i<n;i++){
            int minIndex=-1;
            int minValue=Integer.MAX_VALUE;
            for(int j=0;j<n;j++){
                int currValue=queue.poll();
                if(currValue<minValue && j<(n-i)){
                    minValue=currValue;
                    minIndex=j;
                }
                queue.add(currValue);
            }
            for(int j=0;j<n;j++){
                int currValue=queue.poll();
                if(j!=minIndex || minIndex==-1){
                    queue.add(currValue);
                }
            }
            queue.add(minValue);
        }
        for (Integer i: queue) {
            System.out.print(i + " "); }
        System.out.println();
    }
public static void main(String[] args) {
    Queue <Integer> q1 = new LinkedList<>();
    q1.add(10);
    q1.add(7);
    q1.add(2);
    q1.add(8);
    q1.add(6);
    sortQueue(q1);
   }}