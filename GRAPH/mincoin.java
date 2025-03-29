import java.io.*;
import java.util.*;

public class mincoin {
    // MinCoins Solution Class
    static class Solution {
        public int minCoins(int coins[], int sum) {
            int n = coins.length;
            int[][] dp = new int[n + 1][sum + 1];

            // Initialize dp array
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= sum; j++) {
                    if (j == 0) {
                        dp[i][j] = 0; // No coins needed for sum 0
                    } else {
                        dp[i][j] = Integer.MAX_VALUE - 1; // Initialize with a large value
                    }
                }
            }

            // Fill dp array using bottom-up approach
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= sum; j++) {
                    if (coins[i - 1] <= j) {
                        dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

            // Check if sum can be formed
            for(int i=0;i<n;i++){
                for(int j=0;j<sum;j++){
                    if(dp[i][j]==2147483646){
                        System.out.print("infinite"+" ");
                    }else{

                        System.out.print(dp[i][j]+" ");
                    }
                }
                System.out.println();
            }
            return dp[n][sum] == Integer.MAX_VALUE - 1 ? -1 : dp[n][sum];
        }
    }

    // Driver Code Starts
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine()); // Target sum
            String line = br.readLine(); // Input for coin array
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            Solution obj = new Solution();
            int res = obj.minCoins(arr, k);

            System.out.println(res);
        }
    }
    // Driver Code Ends
}
