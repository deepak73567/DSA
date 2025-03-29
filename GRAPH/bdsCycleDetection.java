import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class bdsCycleDetection {
    
    // Function to add an edge between two vertices
    static void addEdge(ArrayList<Integer> adj[], int u, int v) {
        // Print adjacency list before adding edges
        System.out.println("Adjacency List before adding edge:");
        printAdjacencyList(adj);

        adj[u].add(v);
        adj[v].add(u);

        // Print adjacency list after adding edges
        System.out.println("Adjacency List after adding edge " + u + " - " + v + ":");
        printAdjacencyList(adj);
    }

    // Function to print the adjacency list in a readable format
    static void printAdjacencyList(ArrayList<Integer> adj[]) {
        for (int i = 0; i < adj.length; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < adj[i].size(); j++) {
                System.out.print(adj[i].get(j) + " ");
            }
            System.out.println();
        }
    }

    // Function to detect cycle in a connected graph
    static boolean isCyclicConnected(ArrayList<Integer> adj[], int s, int V, boolean visited[]) {
        int parent[] = new int[V];
        Arrays.fill(parent, -1);
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int i = 0; i < adj[u].size(); i++) {
                int v = adj[u].get(i);
               System.out.println("v:"+v+" "+"u:"+u);
                // If the node is not visited, mark it and add it to the queue
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                    parent[v] = u;
                }
                // If the node is visited and is not the parent of the current node, then it's a cycle
                else if (parent[u] != v) {
                    System.out.println(parent[u] +"isEqual "+v);
                    return true;
                }
                System.out.println(parent[u] +" is "+v+" "+(parent[u]==v));
            }
        }
        return false;
    }

    // Function to detect cycle in a disconnected graph
    static boolean isCyclicDisconnected(ArrayList<Integer> adj[], int V) {
        boolean visited[] = new boolean[V];
        Arrays.fill(visited, false);

        // Check for cycles in each component of the graph
        for (int i = 0; i < V; i++) {
            if (!visited[i] && isCyclicConnected(adj, i, V, visited)) {
                return true;
            }
        }
        return false;
    }

    // Main function
    public static void main(String arg[]) {
        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Integer> adj[] = new ArrayList[V];
        
        // Initialize the adjacency list
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        // Add edges to the graph
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        // addEdge(adj, 2, 0);  // Uncomment this to create a cycle
        addEdge(adj, 2, 3);

        // Check if the graph has a cycle
        if (isCyclicDisconnected(adj, V)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
