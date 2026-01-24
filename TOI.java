
import java.util.Stack;

public class TOI {
    public static void toi(int numDisks,char source,char auxillary,char destination){
        Stack<Integer> sourceStack=new Stack<>();
        Stack<Integer> destinationStack=new Stack<>();
        Stack<Integer> auxillaryStack=new Stack<>();
        for(int i=numDisks;i>=1;i--){
            sourceStack.push(i);
        }
        int totalNumberofMoves=(int) Math.pow(2,numDisks)-1;
        char temp;
        if(numDisks%2==0){
            temp=auxillary;
            auxillary=destination;
            destination=temp;
        }
        for(int i=1;i<=totalNumberofMoves;i++){
            if(i%3==1){
                movedisk(sourceStack,destinationStack,source,destination);
            }
            else if(i%3==2){
                movedisk(sourceStack,auxillaryStack,source,auxillary);
            }
            else{
                movedisk(auxillaryStack,destinationStack,auxillary,destination);
            }
        }
    }
    static void movedisk(Stack<Integer> src, Stack<Integer> dest,
                     char s, char d) {

    if (src.isEmpty()) {
        src.push(dest.pop());
        System.out.println("Move disk " + src.peek() + " from " + d + " to " + s);
    }
    else if (dest.isEmpty()) {
        dest.push(src.pop());
        System.out.println("Move disk " + dest.peek() + " from " + s + " to " + d);
    }
    else if (src.peek() < dest.peek()) {
        dest.push(src.pop());
        System.out.println("Move disk " + dest.peek() + " from " + s + " to " + d);
    }
    else {
        src.push(dest.pop());
        System.out.println("Move disk " + src.peek() + " from " + d + " to " + s);
    }
}
public static void towerOfHanoi(int n, char source, char destination, char auxiliary) {
    if (n == 1) {
        System.out.println("Move disk 1 from " + source + " to " + destination);
        return;
    }
    towerOfHanoi(n - 1, source, auxiliary, destination);
    System.out.println("Move disk " + n + " from " + source + " to " + destination);
    towerOfHanoi(n - 1, auxiliary, destination, source);
    }

    public static void main(String[] args) {
        int numDisks = 6;
        char source='A';
        char auxiliary = 'B';
        char destination = 'C';

        toi(numDisks, source, auxiliary, destination);
    }

}