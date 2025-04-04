
// -------------------------------Recursive---------------------------


// class GoldMineRecursive {
//     public static int collectGold(int[][] mat, int i, int j, int n, int m) {
//         if (i < 0 || i >= n || j >= m) return 0;

//         int right = collectGold(mat, i, j + 1, n, m);
//         int rightUp = collectGold(mat, i - 1, j + 1, n, m);
//         int rightDown = collectGold(mat, i + 1, j + 1, n, m);

//         return mat[i][j] + Math.max(right, Math.max(rightUp, rightDown));
//     }

//     public static int maxGold(int[][] mat) {
//         int n = mat.length, m = mat[0].length, max = 0;
//         for (int i = 0; i < n; i++) {
//             max = Math.max(max, collectGold(mat, i, 0, n, m));
//         }
//         return max;
//     }

//     public static void main(String[] args) {
//         int[][] mat = {
//             {1, 3, 3},
//             {2, 1, 4},
//             {0, 6, 4}
//         };
//         System.out.println("Max Gold (Recursion): " + maxGold(mat));
//     }
// }



// ------------------------------------topdown--------------------------------------

// import java.util.Arrays;

// class GoldMineMemo {
//     public static int collectGold(int[][] mat, int[][] dp, int i, int j, int n, int m) {
//         if (i < 0 || i >= n || j >= m) return 0;
//         if (dp[i][j] != -1) return dp[i][j];

//         int right = collectGold(mat, dp, i, j + 1, n, m);
//         int rightUp = collectGold(mat, dp, i - 1, j + 1, n, m);
//         int rightDown = collectGold(mat, dp, i + 1, j + 1, n, m);

//         return dp[i][j] = mat[i][j] + Math.max(right, Math.max(rightUp, rightDown));
//     }

//     public static int maxGold(int[][] mat) {
//         int n = mat.length, m = mat[0].length;
//         int[][] dp = new int[n][m];
//         for (int[] row : dp) Arrays.fill(row, -1);
//         int max = 0;
//         for (int i = 0; i < n; i++) {
//             max = Math.max(max, collectGold(mat, dp, i, 0, n, m));
//         }
//         return max;
//     }

//     public static void main(String[] args) {
//         int[][] mat = {
//             {1, 3, 3},
//             {2, 1, 4},
//             {0, 6, 4}
//         };
//         System.out.println("Max Gold (Memoization): " + maxGold(mat));
//     }
// }

// -------------------------------------bootom-up-----------------------------------------

// class GoldMineTabulation {
//     public static int maxGold(int[][] mat) {
//         int n = mat.length, m = mat[0].length;
//         int[][] dp = new int[n][m];

//         // Fill last column
//         for (int i = 0; i < n; i++) {
//             dp[i][m - 1] = mat[i][m - 1];
//         }

//         // Fill the rest from right to left
//         for (int j = m - 2; j >= 0; j--) {
//             for (int i = 0; i < n; i++) {
//                 int right = dp[i][j + 1];
//                 int rightUp = (i > 0) ? dp[i - 1][j + 1] : 0;
//                 int rightDown = (i < n - 1) ? dp[i + 1][j + 1] : 0;

//                 dp[i][j] = mat[i][j] + Math.max(right, Math.max(rightUp, rightDown));
//             }
//         }

//         // Find max from first column
//         int max = 0;
//         for (int i = 0; i < n; i++) {
//             max = Math.max(max, dp[i][0]);
//         }

//         return max;
//     }

//     public static void main(String[] args) {
//         int[][] mat = {
//             {1, 3, 3},
//             {2, 1, 4},
//             {0, 6, 4}
//         };
//         System.out.println("Max Gold (Tabulation): " + maxGold(mat));
//     }
// }
