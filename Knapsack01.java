import java.util.*;
public class Knapsack01 {
    public static int knapsack(int wt[],int val[],int w,int n){
        int[][] dp=new int[n+1][w+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=w;j++){
                if(wt[i-1]<=j){
                    dp[i][j]=Math.max(dp[i-1][j],val[i-1]+dp[i-1][j-wt[i-1]]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][w];
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
         int[] wt = {1, 3, 4, 5};
        int[] val = {10, 40, 50, 70};

        int W = 8;

        System.out.println(
            "Maximum Profit = "
            + knapsack(wt, val, W, wt.length));
    }
}