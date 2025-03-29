
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    static class Edge {
        int src;
        int dest;
        int wt;
    
        public Edge(int s, int d, int w) {
          this.src = s;
          this.dest = d;
          this.wt = w;
        }
      }

     static  void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
          }
      
          // 0
          graph[0].add(new Edge(0, 1, 5));
      
          // 1
          graph[1].add(new Edge(1, 0, 5));
          graph[1].add(new Edge(1, 2, 1));
          graph[1].add(new Edge(1, 3, 3));
      
          // 2
          graph[2].add(new Edge(2, 1, 1));
          graph[2].add(new Edge(2, 3, 1));
          graph[2].add(new Edge(2, 4, 4));
      
          // 3
          graph[3].add(new Edge(3, 1, 3));
          graph[3].add(new Edge(3, 2, 1));
      
          // 4
          graph[4].add(new Edge(4, 2, 2));
      
         
      
     } 

     public static void bfs(ArrayList<Edge>[] graph) {
        Queue<Integer> q=new LinkedList<>();
        boolean vis[]=new boolean[graph.length];
        q.add(0);

        while(!q.isEmpty()){
            int curr=q.remove();
            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr]=true;
                for(int i=0;i<graph[curr].size();i++){
                 Edge e=graph[curr].get(i);
                 q.add(e.dest);
                }
            }
        }

     }
    

     public static void dfs(ArrayList<Edge>[] graph,int curr,boolean vis[]){
      System.out.print(curr+" ");

      vis[curr]=true;

      for(int i=0;i<graph[curr].size();i++){
        Edge e=graph[curr].get(i);
        if(!vis[e.dest]){
          dfs(graph,e.dest,vis);
        }
      }
     }
public static void main(String[] args) {
    
int v=7;
ArrayList<Edge> graph[]=new ArrayList[v];
createGraph(graph);
bfs(graph);
System.out.println();
dfs(graph,0,new boolean[v]);

}
}
