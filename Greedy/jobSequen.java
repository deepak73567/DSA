
import java.util.*;

class jobSequen {
    static class JOB {
        int id, deadline, profit;

        public JOB(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    // DSU - Find with path compression
    private int find(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent, parent[x]); // Path compression
    }

    // DSU - Union by rank (simple version to update parent)
    private void union(int[] parent, int u, int v) {
        parent[u] = v; // Update the parent to the next available slot
    }

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;

        // Step 1: Create list of jobs
        ArrayList<JOB> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jobs.add(new JOB(i + 1, deadline[i], profit[i]));
        }

        // Step 2: Sort jobs by profit (descending)
        Collections.sort(jobs, (a, b) -> b.profit - a.profit);

        // Step 3: Find maximum deadline
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, deadline[i]);
        }

        // Step 4: DSU parent initialization
        int[] parent = new int[maxDeadline + 1];
        for (int i = 0; i <= maxDeadline; i++) {
            parent[i] = i; // Self-parent
        }

        // Step 5: Assign jobs to slots
        int maxProfit = 0, countJobs = 0;
        for (JOB job : jobs) {
            // Find the latest available slot ≤ job.deadline
            int availableSlot = find(parent, Math.min(maxDeadline, job.deadline));

            if (availableSlot > 0) {
                // Assign job to this slot and update parent to next available slot
                union(parent, availableSlot, availableSlot - 1);
                maxProfit += job.profit;
                countJobs++;
            }
        }

        // Step 6: Return results
        ArrayList<Integer> res = new ArrayList<>();
        res.add(countJobs);
        res.add(maxProfit);
        return res;
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());

        while (t-- > 0) {
            String[] deadlineInput = sc.nextLine().trim().split("\\s+");
            int[] deadline = Arrays.stream(deadlineInput).mapToInt(Integer::parseInt).toArray();

            String[] profitInput = sc.nextLine().trim().split("\\s+");
            int[] profit = Arrays.stream(profitInput).mapToInt(Integer::parseInt).toArray();

            jobSequen obj = new jobSequen(); 
            ArrayList<Integer> result = obj.jobSequencing(deadline, profit);
            System.out.println(result.get(0) + " " + result.get(1));
            System.out.println("~");
        }

        sc.close();
    }
   
}



