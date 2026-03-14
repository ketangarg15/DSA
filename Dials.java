import java.util.*;

class Pair{
    int node,dist;
    public Pair(int n,int d) {
        node=n;
        dist=d;
    }
}
public class Dials {
    public static void dijkstra(int V,List<List<Pair>> adj,int src){
        int[] dist=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.dist-b.dist);
        pq.add(new Pair(src,0));
        dist[src]=0;
        while(!pq.isEmpty()){
            Pair p =pq.poll();
            int node=p.node;
            for(Pair neighbor:adj.get(node)){
                int v=neighbor.node;
                int weight=neighbor.dist;
                if(dist[node]+weight<dist[v]){
                    dist[v]=dist[node]+weight;
                    pq.add(new Pair(v,dist[v]));
                }
            }
        }
        for(int i=0;i<V;i++){
            System.out.println(dist[i]);
        }
    }
    public static void main(String[] args) {
        int V = 5;

        List<List<Pair>> adj = new ArrayList<>();

        for(int i=0;i<V;i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(new Pair(1,2));
        adj.get(0).add(new Pair(2,4));
        adj.get(1).add(new Pair(2,1));
        adj.get(1).add(new Pair(3,7));
        adj.get(2).add(new Pair(4,3));
        dijkstra(V, adj, 0);
    }
}
