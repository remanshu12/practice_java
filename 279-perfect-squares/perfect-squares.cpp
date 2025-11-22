class Solution {
public:
    int numSquares(int n) {
          vector<int> val;
        for(int i = 1; i*i <= n; i++) {
            val.push_back(i * i);
        }

        int m = val.size();
        vector<vector<int>> dp(m+1, vector<int>(n+1, 1e9));
        for(int i=0;i<=m;i++){
            dp[i][0]=0;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(val[i-1]<=j){
                    dp[i][j]=min(1+dp[i][j-val[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[m][n];





    }
};