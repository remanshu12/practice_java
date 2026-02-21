class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int n=matrix.size();
        int m=matrix[0].size();
        vector<vector<int>> dp(n,vector<int>(m,0));
        for(int j=0;j<m;j++){
            dp[0][j]=matrix[0][j];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                int up=dp[i-1][j];
                int leftdig=(j>0)?dp[i-1][j-1]:INT_MAX;
                int rightdig=(j<m-1)?dp[i-1][j+1]:INT_MAX;
                dp[i][j]=matrix[i][j]+min(rightdig,min(up,leftdig));
            }
        }
        int mini=INT_MAX;
        for(int j=0;j<m;j++){
            mini=min(mini,dp[n-1][j]);
        }
        return mini;

    }
};