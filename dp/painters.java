import java.util.*;

class painters {
    public static int minTime(int[] arr, int k) {
        int n = arr.length;
        int[][] dp = new int[k + 1][n + 1]; // dp[i][j] = min time for i painters and j boards
        
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
            System.out.print(prefixSum[i+1]+" ");
        }
           
        System.out.println();
        // Base Case: If we have only 1 painter, he paints all boards
        for (int j = 1; j <= n; j++) {
            dp[1][j] = prefixSum[j];
            System.out.print(dp[1][j]+" ");

        }
        System.out.println();
        // Fill DP Table
        for (int i = 2; i <= k; i++) { // For each painter
            for (int j = 1; j <= n; j++) { // For each board count
                int best = Integer.MAX_VALUE;
                for (int p = 0; p < j; p++) { // Partitioning at index p
                    best = Math.min(best, Math.max(dp[i - 1][p], prefixSum[j] - prefixSum[p]));
                }
                dp[i][j] = best;
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for(int j=0;j<dp[i].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[k][n];
    }

    public static void main(String[] args) {
        int[] arr = {5, 10, 30, 20, 15};
        int k = 3; // Number of painters

        int result = minTime(arr, k);
        System.out.println("Minimum time required: " + result);
    }
}
