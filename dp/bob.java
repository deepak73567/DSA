import java.util.*;

public class bob {
    public static long calculateDifference(long[] A, int N) {
        long total = 0;
        long even_sum = 0, odd_sum = 0;

        // Prefix sum array to store prefix sums
        long[] prefix = new long[N + 1];

        // Calculate total, prefix sums, and even/odd sums
        for (int i = 0; i < N; i++) {
            total += A[i];
            prefix[i + 1] = prefix[i] + A[i];

            if (i % 2 == 0) {
                even_sum += A[i]; // Even indexed elements
            } else {
                odd_sum += A[i]; // Odd indexed elements
            }
        }

        // Calculate three possible differences
        long diff_same = Math.abs(even_sum - odd_sum);

        int k_lr = (N + 1) / 2;
        long diff_lr = Math.abs(2 * prefix[k_lr] - total);

        int k_rl = N / 2;
        long diff_rl = Math.abs(total - 2 * prefix[k_rl]);

        // Return the minimum of the three differences
        return Math.min(diff_same, Math.min(diff_lr, diff_rl));
    }

    public static void main(String[] args) {
        long[] A = {3, 7, 2, 9, 4}; // Example input
        int N = A.length;

        System.out.println("Minimum Difference: " + calculateDifference(A, N));
    }
}