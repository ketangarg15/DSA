import java.util.*;
public class SubsetSum {
    static boolean subsetSum(int[] arr,int n,int sum){
        if(sum==0){
            return true;
        }
        if(n==0){
            return false;
        }
        if(arr[n-1]>sum){
            return subsetSum(arr, n-1, sum);
        }
        return subsetSum(arr, n-1, sum-arr[n-1])||subsetSum(arr, n-1, sum);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] arr = {3, 34, 4, 12, 5, 2};

        int sum = 90;

        System.out.println(
            subsetSum(arr,
                      arr.length,
                      sum));
    }
}
