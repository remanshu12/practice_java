class Solution {
    public int numSquares(int n) {
          // Step 1: perfect squares only <= n
        ArrayList<Integer> val = new ArrayList<>();
        for(int i = 1; i*i <= n; i++){
            val.add(i * i);
        }

        int m = val.size();

        // Step 2: DP array
        int[][] dp = new int[m + 1][n + 1];

        // initialize with INF (1e9 in Java)
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                dp[i][j] = 1000000000;  // INF (1e9)
            }
        }

        // base case
        for(int i = 0; i <= m; i++){
            dp[i][0] = 0;
        }

        // Step 3: Fill DP (Unbounded Knapsack Logic)
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(val.get(i - 1) <= j) {
                    dp[i][j] = Math.min(1 + dp[i][j - val.get(i - 1)], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }
}