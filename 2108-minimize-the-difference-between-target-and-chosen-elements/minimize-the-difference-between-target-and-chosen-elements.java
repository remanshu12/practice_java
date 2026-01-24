import java.util.Arrays;
class Solution {
    Integer[][] dp = new Integer[5001][71];
    int rows, cols; 
    public int minimizeTheDifference(int[][] mat, int target) {
        rows = mat.length;
        cols = mat[0].length;
        for (Integer[] row : dp) {
            Arrays.fill(row, -1);
        }
        return find(mat, 0, 0, target);
    }
    public int find(int[][] mat, int r, int sum, int target) {
        if (r == rows) {
            return Math.abs(sum - target);
        }
        if (dp[sum][r] != -1) {
            return dp[sum][r];
        }
        int minDiff = Integer.MAX_VALUE;
        for (int j = 0; j < cols; j++) {
            int result = find(mat, r + 1, sum + mat[r][j], target);
            minDiff = Math.min(minDiff, result);
        }
        return dp[sum][r] = minDiff;
    }
}