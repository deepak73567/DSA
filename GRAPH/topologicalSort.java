// import java.util.*;
// public class topologicalSort {
//     public static  class Edge{
//         int src;
//         int dest;

//         public Edge(int s,int d){
//             this.src=s;
//             this.dest=d;
//         }
//         @Override
//         public String toString() {
//             return "Edge{" + "src=" + src + ", dest=" + dest + '}';
//         }
//     }

//     static  void createGraph(ArrayList<Edge> graph[]){
//         for (int i = 0; i < graph.length; i++) {
//             graph[i]=new ArrayList<>();
//         }

//         graph[2].add(new Edge(2, 3));
//         graph[3].add(new Edge(3, 1));
//         graph[4].add(new Edge(4, 0));
//         graph[4].add(new Edge(4, 1));
//         graph[5].add(new Edge(5, 0));
//         graph[5].add(new Edge(5, 2));
//     }
   
//     public static void topSortUtil(ArrayList<Edge> graph[],int curr,boolean [] vis,Stack<Integer> s) {
//         vis[curr]=true;
//         for (int i = 0; i <graph[curr].size(); i++) {
//             System.out.println(i+"->");
//             Edge e=graph[curr].get(i);
//             System.out.println(e);
//             for (int k = 0; k <vis.length ; k++) {
//                 System.out.print(vis[k]+" ");
//             }
//             System.out.println();
//             // System.out.println("src: " + e.src + ", dest: " + e.dest);
//             if(!vis[e.dest]){
//                 topSortUtil(graph, e.dest, vis, s);
//             }

//         }
//         s.push(curr);
//     }

//     public static void TopSort(ArrayList<Edge> graph[]) {
//         boolean vis[]=new boolean[graph.length];
//         Stack<Integer> s=new Stack<>();

//         for (int i = 0; i < graph.length; i++) {
//             if(!vis[i]){
//                 topSortUtil(graph,i,vis,s);
//             }
//         }

//         while(!s.isEmpty()){
//             System.out.println(s.pop()+" ");
//         }
        
//     }

//     public static void main(String[] args) {
//         int V=6;
//         ArrayList<Edge> graph[]=new ArrayList[V];
//         createGraph(graph);
//         TopSort(graph);
//     }
// }
import java.util.*;

public class topologicalSort {

    // Topological Sort utility method
    public static void topSortUtil(ArrayList<Integer>[] graph, int curr, boolean[] vis, Stack<Integer> s) {
        vis[curr] = true;
        
        for (int i = 0; i < graph[curr].size(); i++) {
            int dest = graph[curr].get(i);
            System.out.println("Visiting edge: " + curr + " -> " + dest);
            for (int k = 0; k < vis.length; k++) {
                System.out.print(vis[k] + " ");
            }
            System.out.println();
            if (!vis[dest]) {
                topSortUtil(graph, dest, vis, s);
            }
        }
        s.push(curr);  // Push the current node after visiting all its neighbors
    }

    // Topological Sort
    public static void TopSort(ArrayList<Integer>[] graph, int numCourses) {
        boolean vis[] = new boolean[numCourses];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                topSortUtil(graph, i, vis, s);
            }
        }

        System.out.println("\nTopological Sort:");
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
        System.out.println();
    }

    public static void printGraph(ArrayList<Integer>[] graph, int numCourses) {
        System.out.println("Graph:");
        for (int i = 0; i < numCourses; i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < graph[i].size(); j++) {
                System.out.print(graph[i].get(j) + " ");
            }
            System.out.println();
        }
    }

    // Create graph from prerequisites array
    public static void createGraph(int numCourses, int[][] prerequisites, ArrayList<Integer>[] graph) {
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];
            graph[pre].add(course);  // Add edge from prerequisite to course
        }
    }

    public static void main(String[] args) {
        int numCourses = 4;  // Number of courses
        int[][] prerequisites = {
            {1, 0},  // Course 0 -> 1
            {2, 0},  // Course 0 -> 2
            {3, 1},  // Course 1 -> 3
            {3, 2}   // Course 2 -> 3
        };

        // Create graph
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        createGraph(numCourses, prerequisites, graph);

        // Print the graph
        printGraph(graph, numCourses);

        // Perform Topological Sort
        TopSort(graph, numCourses);
    }
}
