
import java.util.ArrayList;

public class HasPth {
    public static  class Edge{
        int src;
        int dest;

       public  Edge(int s,int d){
        this.src=s;
        this.dest=d;
        }
    }
public static boolean  dfs(ArrayList<Edge>[] graph,int src,int dest,boolean vis[]) {
    // System.out.println(curr+" ");
    if(src==dest){
        return true;
    }
    vis[src]=true;
    
    for(int i=0;i<graph[src].size();i++){
        Edge e=graph[src].get(i);
        if(!vis[e.dest] && dfs(graph, e.dest, dest, vis)){
           return true;
        }

    }
    return false;
}

public static void main(String[] args) {
    int v=7;
    ArrayList<Edge> graph[]=new ArrayList[v];
    for(int i=0;i<graph.length;i++){
        graph[i]=new ArrayList<>();
    }
    graph[0].add(new Edge(0, 1));
    graph[0].add(new Edge(0, 2));

    graph[1].add(new Edge(1, 3));
    graph[2].add(new Edge(2, 4));

    graph[3].add(new Edge(3, 4));
    graph[3].add(new Edge(3, 5));

    graph[4].add(new Edge(4, 5));

    graph[5].add(new Edge(5, 6));

    System.out.println(dfs(graph,0,5,new boolean[v]));
}
}
