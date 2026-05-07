import java.util.*;
public class LongestIncreasing {
    static int lis(int[] arr){
        int n=arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int maxLen=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            maxLen=Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};

        System.out.println("Length of LIS: " + lis(arr));
    }
}
