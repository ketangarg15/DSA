import java.util.*;
public class TopoLogicalSorting {
    public static void toposort(int V,List<List<Integer>> adj){
        int[] indegree=new int[V];
        for(int i=0;i<V;i++){
            for(int neigbor:adj.get(i)){
                indegree[neigbor]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int count=0;
        while(!q.isEmpty()){
            int node=q.poll();
            System.out.print(node+" ");
            count++;
            for(int neighbor:adj.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor]==0){
                    q.add(neighbor);
                }
            }
        }
        if(count!=V){
            System.out.print("Cycle detected");
        }
    }
    public static void main(String[] args) {
        int V = 6;

        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);
        toposort(V, adj);
    }
}
