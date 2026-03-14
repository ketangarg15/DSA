import java.util.*;
class Edge{
    int u,v,w;
    Edge(int u,int v,int w){
        this.u=u;
        this.v=v;
        this.w=w;
    }
}
public class Bellman {
    public static void bellmanFord(int V,List<Edge> edges,int src){
        int[] dist=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        for(int i=1;i<V;i++){
            for(int j=0;j<edges.size();j++){
                int u=edges.get(j).u;
                int v=edges.get(j).v;
                int w=edges.get(j).w;
                if(dist[u]!=Integer.MAX_VALUE && dist[u]+w<dist[v]){
                    dist[v]=dist[u]+w;
                }
            }
        }
        for(int j=0;j<edges.size();j++){
            int u=edges.get(j).u;
            int v=edges.get(j).v;
            int w=edges.get(j).w;
            if(dist[u]!=Integer.MAX_VALUE&& dist[u]+w<dist[v]){
                System.out.println("-ve weight cycle detected");
                return;
            }
        }
        for(int i = 0; i < V; i++) {
            System.out.println("Distance from " + src + " to " + i + " = " + dist[i]);
        }
    }
    public static void main(String[] args) {

        int V = 5;

        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0,1,2));
        edges.add(new Edge(0,2,4));
        edges.add(new Edge(1,2,1));
        edges.add(new Edge(1,3,7));
        edges.add(new Edge(2,4,3));

        bellmanFord(V, edges, 0);
    }
}
