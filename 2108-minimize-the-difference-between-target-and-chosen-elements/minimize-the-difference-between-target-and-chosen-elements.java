class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {

        int maxSum = 70 * mat.length; // max possible sum
        boolean[] dp = new boolean[maxSum + 1];
        dp[0] = true;

        for (int[] row : mat) {
            boolean[] next = new boolean[maxSum + 1];

            for (int s = 0; s <= maxSum; s++) {
                if (!dp[s]) continue;

                for (int val : row) {
                    next[s + val] = true;
                }
            }
            dp = next;
        }

        int ans = Integer.MAX_VALUE;
        for (int s = 0; s <= maxSum; s++) {
            if (dp[s]) {
                ans = Math.min(ans, Math.abs(s - target));
            }
        }

        return ans;
    }
}
