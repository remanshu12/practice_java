class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        int n=grid.size();
        int m=grid[0].size();
        vector<vector<int>> dp(n,vector<int>(m,0));
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0 ){
                    dp[i][j]=grid[i][j];
                    continue;
                }
                int up=0;
                int left=0;
                if(i>0) up=dp[i-1][j];
                else{
                    up=dp[i][j-1];
                }
                if(j>0) left=dp[i][j-1];
                else{
                    left=dp[i-1][j];
                }
                dp[i][j]=grid[i][j]+min(up,left);

            }
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         cout << dp[i][j] << " ";
        //     }
        //     cout << '\n';
        // }
        return dp[n-1][m-1];
    }
};