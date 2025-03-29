

import java.io.*;
import java.util.*;

public class unbound {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine()); // Number of test cases
        while (t-- > 0) {
            int w = Integer.parseInt(in.readLine().trim()); // Capacity of knapsack

            // Read values array
            String line2[] = in.readLine().trim().split(" ");
            int N = line2.length;
            int val[] = new int[N];
            for (int i = 0; i < N; i++) {
                val[i] = Integer.parseInt(line2[i]);
            }

            // Read weights array
            String line3[] = in.readLine().trim().split(" ");
            int wt[] = new int[N];
            for (int i = 0; i < N; i++) {
                wt[i] = Integer.parseInt(line3[i]);
            }

            // Call knapSack function directly
            System.out.println(knapSack(N, w, val, wt));
        }
    }
    static void print(int[][] dp){
        int n=dp.length;
        int m=dp[0].length;
   for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
        System.out.print(dp[i][j]+" ");
    }
    System.out.println();
   }
    }
    static int knapSack(int N, int capacity, int val[], int wt[]) {
        int dp[][] = new int[N + 1][capacity + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i][j - wt[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        print(dp);
        return dp[N][capacity];
    }
}
