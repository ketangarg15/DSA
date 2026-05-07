import java.util.*;
public class Distributing {
    static boolean checkCount(int n,int arr[],int k){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i], 0)+1);
        }
        for(int x: map.keySet()){
            if(map.get(x)>2*k){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] arr = {1, 1, 2, 3, 1};

        int n = arr.length;

        int k = 2;

        System.out.println(checkCount(n,arr, k));
    }
}
