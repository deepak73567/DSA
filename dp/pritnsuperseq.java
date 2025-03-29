import java.util.*;

class pritnsuperseq {
    // Function to find and return the shortest common supersequence
    static String shortestCommonSupersequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Filling the dp table
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Constructing the shortest supersequence
        int i = m, j = n;
        StringBuilder result = new StringBuilder();
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                result.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] < dp[i][j - 1]) {
                result.append(s1.charAt(i - 1));
                i--;
            } else {
                result.append(s2.charAt(j - 1));
                j--;
            }
        }

        // Adding remaining characters
        while (i > 0) {
            result.append(s1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            result.append(s2.charAt(j - 1));
            j--;
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.println(shortestCommonSupersequence(s1, s2));
    }
}

