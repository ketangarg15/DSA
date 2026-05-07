import java.util.*;
public class LongestBitonic {
    static int lbs(int arr[],int n){
        int[] lis=new int[n];
        int[] lid=new int[n];
        Arrays.fill(lis,1);
        Arrays.fill(lid,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    lis[i]=Math.max(lis[i],lis[j]+1);
                }
            }
        }
        for(int i=n-2;i>=0;i--){
            for(int j=n-1;j>i;j--){
                if(arr[i]>arr[j]){
                    lid[i]=Math.max(lid[i],lid[j]+1);
                }
            }
        }
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,lid[i]+lis[i]-1);
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] arr =
            {1, 11, 2, 10, 4, 5, 2, 1};

        int n = arr.length;

        System.out.println(
            "Length of LBS = "
            + lbs(arr, n));
    }   
}