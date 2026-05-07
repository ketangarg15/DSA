
import java.util.HashSet;

class Sets{
    public static void main(String[] args) {
        HashSet<Integer> hashset=new HashSet<>();
        hashset.add(2);
        hashset.add(23);
        hashset.add(222);

        hashset.remove(2);
        if(hashset.contains(23)){
            System.out.println("true");
        }
        
    }
}