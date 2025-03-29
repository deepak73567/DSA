
// import java.util.ArrayList;

// public class detectCycle {
//      static class Edge{
//         int src;
//         int dest;

//         public Edge(int src,int dest){
//             this.src=src;
//             this.dest=dest;
//         }
//      }

//    public static void createGraph(ArrayList<Edge> graph[]) {
//     for (int i = 0; i < graph.length; i++) {
//         graph[i]=new ArrayList<>();
//     }

//     graph[0].add(new Edge(0, 1) );
//     graph[0].add(new Edge(0, 2) );
//     graph[1].add(new Edge(1, 3) );
//     graph[2].add(new Edge(2, 3) );
//    }

//    public static boolean  isCycle(ArrayList<Edge>[] graph) {
//        boolean vis[]=new boolean[graph.length];
//        boolean stack[]=new boolean[graph.length];

//        for (int i = 0; i < graph.length; i++) {
//            if(!vis[i]){
//             if(isCycleUtill(graph,i,vis,stack)){
//                 return true;
//             }
//            }
//        }
// return false;
//    }

//    public static boolean  isCycleUtill(ArrayList<Edge>[] graph,int curr,boolean vis[],boolean stack[]) {
//       vis[curr]=true;
//       stack[curr]=true;
//       for (int i = 0; i <graph[curr].size(); i++) {
//           Edge e=graph[curr].get(i);
//           if(stack[e.dest]){
//             System.out.println("e:"+e);
//             System.out.println("ed:"+e.dest);
//             return true;
//           }
//           if(!vis[e.dest] && isCycleUtill(graph, e.dest, vis, stack)){
//             System.out.println("e:"+e);
//             System.out.println("ed:"+e.dest);
//          return  true;
//           }
//       }
//       stack[curr]=false;
//       return false;
//    }
//     public static void main(String[] args) {
//         int v=4;
//         ArrayList<Edge> graph[]=new ArrayList[v];
//         createGraph(graph);
//         System.out.println(isCycle(graph));
//     }
// }
import java.io.*;
import java.lang.*;
import java.util.*;

class detectCycle {
    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++) list.add(i, new ArrayList<>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(list) == true)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}

// Complete the function below
class Solution {
    public boolean isCycleUtil(ArrayList<ArrayList<Integer>> adj, int curr, boolean vis[], boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < adj.get(curr).size(); i++) {
            int neighbor = adj.get(curr).get(i);
            if (!vis[neighbor]) {
                if (isCycleUtil(adj, neighbor, vis, stack))
                    return true;
            } else if (stack[neighbor]) {
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] vis = new boolean[V];
        boolean[] stack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (isCycleUtil(adj, i, vis, stack))
                    return true;
            }
        }
        return false;
    }
}
