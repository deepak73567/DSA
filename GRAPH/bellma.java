
import java.util.ArrayList;


public class bellma {
    static  class  Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }


    static  void createGraph(ArrayList<Edge> graph[]){
     for(int i=0;i<graph.length;i++){
        graph[i]=new ArrayList<>();
     }
     graph[0].add(new Edge(0, 1, 2));
     graph[0].add(new Edge(0, 2, 4));

     graph[1].add(new Edge(1, 2, -4));

     graph[2].add(new Edge(2, 3, 2));

     graph[3].add(new Edge(3, 4, 4));
     graph[4].add(new Edge(4, 1, -1));
    }

    static  void createGraph2(ArrayList<Edge> graph){
       
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));
   
        graph.add(new Edge(1, 2, -4));
   
        graph.add(new Edge(2, 3, 2));
   
        graph.add(new Edge(3, 4, 4));
        graph.add(new Edge(4, 1, -1));
       }
     
    public static void bellman(ArrayList<Edge> graph,int src,int V) {
       
        int dist[]=new int[V];
        for(int i=0;i<V;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }

      for(int i=0;i<V-1;i++){
        for(int j=0;j<graph.size();j++){
            
                Edge e=graph.get(j);
                int u=e.src;
                int v=e.dest;
                int w=e.wt;

                if(dist[u]!=Integer.MAX_VALUE && dist[u]+w<dist[v]){
                    dist[v]=dist[u]+w;
                }
            }
        }
      
      for(int i=0;i<dist.length;i++){
        System.out.print(dist[i]+" ");
      }
    }
    public static void main(String[] args) {
        int V=5;
        // ArrayList<Edge> graph[]=new ArrayList[V];
        ArrayList<Edge> graph=new ArrayList<>();
        // createGraph(graph);
        createGraph2(graph);
        bellman(graph,0,V);
    }
}
