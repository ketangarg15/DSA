import java.util.Stack;

public class Celebrityproblem {
    public static int findcelebrity(int mat[][],int n){
        for(int i=0;i<n;i++){
            boolean isKnownbyall=true;
            boolean knowsnoone=true;
            for(int j=0;j<n;j++){
                if(i!=j && mat[i][j]==1){
                    knowsnoone=false;
                }
                if(i!=j && mat[j][i]==0){
                    isKnownbyall=false;
                }
            }
            if(isKnownbyall && knowsnoone){
                return i;
            }
        }
        return -1;
    }
    static int[][] M = {
        {0, 1, 1, 0},
        {0, 0, 1, 0},
        {0, 0, 0, 0},
        {0, 1, 1, 0}
    };
    static boolean knows(int a, int b) {
        return M[a][b] == 1;
    }

    static int findCelebrity(int n) {
        Stack<Integer> stack = new Stack<>();

        // Step 1: Push all people
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        // Step 2: Eliminate non-celebrities
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();

            if (knows(a, b)) {
                stack.push(b); // a cannot be celebrity
            } else {
                stack.push(a); // b cannot be celebrity
            }
        }

        // Step 3: Verify candidate
        int candidate = stack.pop();

        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                if (knows(candidate, i) || !knows(i, candidate)) {
                    return -1; // No celebrity
                }
            }
        }

        return candidate;
    }
    public static void main(String[] args) {
        int[][] M = {
        {0, 1, 1, 0},
        {0, 0, 1, 0},
        {0, 0, 0, 0},
        {0, 1, 1, 0}
    };
    System.out.println("Celebrity (Brute Force): " + findcelebrity(M,4));
    }
}
