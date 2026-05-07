import java.util.*;
public class LCS_Code {
    static int lcs(String a,String b){
        int n=a.length();
        int m=b.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        int i=n,j=m;
        while(i>0 &&j>0){
            if(a.charAt(i-1)==b.charAt(j-1)){
                sb.append(a.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                i--;
            }
            else{
                j--;
            }
        }
        System.out.println(sb.reverse().toString());
        return dp[n][m];
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String a="AbcbaabA";
        StringBuilder b=new StringBuilder(a);
        b=b.reverse();

        System.out.println(lcs(a,b.toString()));
    }
}
