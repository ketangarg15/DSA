import java.util.HashMap;
import java.util.TreeMap;

public class HashMaptoTreeMap {
    public static void main(String[] args){
        HashMap<Integer, String> hashMap = new HashMap<>();

        hashMap.put(3, "Apple");
        hashMap.put(1, "Banana");
        hashMap.put(2, "Mango");

        System.out.println("HashMap:");
        System.out.println(hashMap);
        TreeMap<Integer,String> treeMap=new TreeMap<>(hashMap);
        System.out.println("TreeMap:");
        System.out.println(treeMap);
    }
}
