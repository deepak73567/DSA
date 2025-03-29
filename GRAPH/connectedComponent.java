import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class connectedComponent {

    static class Edge {
        int src;
        int dest;
        
    
        public Edge(int s, int d) {
          this.src = s;
          this.dest = d;
      
        }
      }

      public static  void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
          }
      
          // 0
          graph[0].add(new Edge(0, 1));
        //   graph[0].add(new Edge(0, 2));
          graph[0].add(new Edge(0,3 ));
      
          // 1
          graph[1].add(new Edge(1, 0));
          graph[1].add(new Edge(1, 2));
          
          
        //   graph[2].add(new Edge(2,0 ));
          graph[2].add(new Edge(2, 1));
         
          
          graph[3].add(new Edge(3, 0));
          graph[3].add(new Edge(3,4 ));
          
          graph[4].add(new Edge(4, 3));
    
         
      
     } 

    public static void bfs(ArrayList<Edge>[] graph) {
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                bfsUtill(graph, vis);
            }
        }
    }

      public static void bfsUtill(ArrayList<Edge>[] graph,boolean  vis[]) {
        Queue<Integer> q=new LinkedList<>();
        
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

     public static void dfs(ArrayList<Edge>[] graph) {
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                dfsUtill(graph,i, vis);
            }
        }
     }

     public static void dfsUtill(ArrayList<Edge>[] graph,int curr,boolean vis[]){
        System.out.print(curr+" ");
  
        vis[curr]=true;
  
        for(int i=0;i<graph[curr].size();i++){
          Edge e=graph[curr].get(i);
          if(!vis[e.dest]){
            dfsUtill(graph,e.dest,vis);
          }
        }
       }

       public static boolean  detectCycle(ArrayList<Edge>[] graph) {
             
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(detectCycleUtil(graph,vis,i,-1)){
                    return true;
                }
            }
        }
        return false;
       }

       public static boolean detectCycleUtil(ArrayList<Edge>[] graph,boolean vis[],int curr,int par) {
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            //case 3
         if(!vis[e.dest]){
            if(detectCycleUtil(graph,vis,e.dest,curr))
     return true;
         }
         // case 1
         else if(vis[e.dest] && e.dest !=par){
            return true;
         }
         //case 2 continue;
        }
        return false;
       }
    public static void main(String[] args) {
 /*  /  0-----------3
   1   |           |
   \   |           |
    \  |           4
       2
*/   
      int v=5;
      ArrayList<Edge> graph[]=new ArrayList[v];
      createGraph(graph);
      System.out.println(detectCycle(graph));
    
    }
}
