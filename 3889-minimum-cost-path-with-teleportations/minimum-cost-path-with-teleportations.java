import java.util.*;

class Solution {
    public int minCost(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int maxVal = 0;
        for (int[] row : grid) {
            for (int val : row) maxVal = Math.max(maxVal, val);
        }

        // dp[t][i][j] is the min cost to reach (i, j) with t teleports
        int[][][] dp = new int[k + 1][m][n];
        for (int[][] t : dp) {
            for (int[] row : t) Arrays.fill(row, 1_000_000_000);
        }

        dp[0][0][0] = 0;

        for (int t = 0; t <= k; t++) {
            // 1. Handle Normal Moves (Right and Down)
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i > 0) dp[t][i][j] = Math.min(dp[t][i][j], dp[t][i - 1][j] + grid[i][j]);
                    if (j > 0) dp[t][i][j] = Math.min(dp[t][i][j], dp[t][i][j - 1] + grid[i][j]);
                }
            }

            // 2. Handle Teleportation to the next level (t + 1)
            if (t < k) {
                int[] bestAtVal = new int[maxVal + 1];
                Arrays.fill(bestAtVal, 1_000_000_000);
                
                // Find best cost for each grid value at current teleport count t
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        bestAtVal[grid[i][j]] = Math.min(bestAtVal[grid[i][j]], dp[t][i][j]);
                    }
                }

                // Suffix minimum: suffixMin[v] = min(bestAtVal[v...maxVal])
                int[] suffixMin = new int[maxVal + 1];
                int currentMin = 1_000_000_000;
                for (int v = maxVal; v >= 0; v--) {
                    currentMin = Math.min(currentMin, bestAtVal[v]);
                    suffixMin[v] = currentMin;
                }

                // Update dp[t+1] for all cells based on suffixMin
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        dp[t + 1][i][j] = Math.min(dp[t + 1][i][j], suffixMin[grid[i][j]]);
                    }
                }
            }
        }

        int ans = 1_000_000_000;
        for (int t = 0; t <= k; t++) {
            ans = Math.min(ans, dp[t][m - 1][n - 1]);
        }
        return ans;
    }
}