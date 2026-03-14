import java.util.*;

public class BfsanDfs {
    public static void bfs(int start,List<List<Integer>> adj,boolean[] vis){
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        vis[start]=true;
        while(!q.isEmpty()){
            int node=q.poll();
            System.out.print(node+"");
            for(int neighbor:adj.get(node)){
                if(!vis[neighbor]){
                    vis[neighbor]=true;
                    q.add(neighbor);
                }
            }
        }
    }
    public static void dfs(int start,List<List<Integer>> adj,boolean vis[]){
        Stack<Integer> stack=new Stack<>();
        stack.push(start);
        vis[start]=true;
        while(!stack.isEmpty()){
            int node=stack.pop();
            System.out.print(node+" ");
            for(int neighbor:adj.get(node)){
                if(!vis[neighbor]){
                    vis[neighbor]=true;
                    stack.push(neighbor);
                }
            }
        }
    }
    public static void main(String[] args) {
        int V=5;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(2).add(4);
        boolean[] visited = new boolean[V];
        bfs(0, adj, visited);
        Arrays.fill(visited,false);
        dfs(0, adj, visited);
    }
}
