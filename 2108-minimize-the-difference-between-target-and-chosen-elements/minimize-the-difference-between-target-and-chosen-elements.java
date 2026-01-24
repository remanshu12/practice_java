import java.util.*;

class Solution {

    int[][] dp;
    int rows, cols;
    int target;

    private int find(int[][] mat, int r, int sum) {
        // Base case: all rows processed
        if (r == rows) {
            return Math.abs(sum - target);
        }

        // Memoized result
        if (dp[sum][r] != -1) {
            return dp[sum][r];
        }

        int minDiff = Integer.MAX_VALUE;

        // Try all choices in current row
        for (int j = 0; j < cols; j++) {
            minDiff = Math.min(
                minDiff,
                find(mat, r + 1, sum + mat[r][j])
            );
        }

        return dp[sum][r] = minDiff;
    }

    public int minimizeTheDifference(int[][] mat, int target) {
        this.rows = mat.length;
        this.cols = mat[0].length;
        this.target = target;

        // Max sum = 70 * 70 = 4900 (safe)
        dp = new int[5001][rows];

        // Initialize DP with -1
        for (int i = 0; i < 5001; i++) {
            Arrays.fill(dp[i], -1);
        }

        return find(mat, 0, 0);
    }
}
