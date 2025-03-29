import java.util.*;

class leetcodetoposort {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Create adjacency list for graph representation
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Indegree array to count incoming edges
        int[] indeg = new int[numCourses];

        // Build graph and calculate indegree
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][1]; // prerequisite (source)
            int v = prerequisites[i][0]; // course (destination)
            graph.get(u).add(v);         // Add edge u -> v
            System.out.println("added:"+"u=>"+u+" : "+"v=>"+v);
            System.out.println(graph);
            indeg[v]++;  
            for (int k = 0; k < indeg.length; k++) {
                
                System.out.print(indeg[k]+" ");
            }              // Increase indegree of destination
        }

        // Queue to store nodes with 0 indegree
        Queue<Integer> q = new LinkedList<>();

        // Add all nodes with indegree 0 to the queue
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }

        // Result array to store topological order
        int[] result = new int[numCourses];
        int val = 0;

        // Kahn's Algorithm - BFS
        while (!q.isEmpty()) {
            System.out.println(q);
            int curr = q.poll();  // Remove course with 0 indegree
            result[val] = curr;   // Add course to result
            val++;

            // Reduce indegree of neighbors and check if they become 0
            for (int v : graph.get(curr)) {
                System.out.println(v);
                indeg[v]--;
                if (indeg[v] == 0) {
                    q.add(v);
                    // System.out.println(q);
                }
            }
        }

        // If all courses are processed, return result
        if (val == numCourses) {
            return result;
        } else {
            return new int[0]; // Return empty array if cycle is detected
        }
    }

    // Main function to test the code
    public static void main(String[] args) {
        leetcodetoposort sol = new leetcodetoposort();


        // Test case 1
        int numCourses1 = 4;
        int[][] prerequisites1 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] result1 = sol.findOrder(numCourses1, prerequisites1);
        System.out.println("Order of courses for Test 1: " + Arrays.toString(result1));

        // Test case 2 - No prerequisites
        int numCourses2 = 2;
        int[][] prerequisites2 = {};
        int[] result2 = sol.findOrder(numCourses2, prerequisites2);
        System.out.println("Order of courses for Test 2: " + Arrays.toString(result2));

        // Test case 3 - Cycle in graph
        int numCourses3 = 2;
        int[][] prerequisites3 = {{1, 0}, {0, 1}};
        int[] result3 = sol.findOrder(numCourses3, prerequisites3);
        System.out.println("Order of courses for Test 3: " + Arrays.toString(result3));
    }
}
