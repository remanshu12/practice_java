class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        int n=triangle.size();
        int m=triangle[n-1].size();
       
        vector<vector<int>> dp(n,vector<int>(m,0));
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if(i==0 && j==0){
                    dp[i][j]=triangle[i][j];
                    continue;
                }
                int dig=INT_MAX;
                int up=INT_MAX;
                if(i!=j){
                    up=dp[i-1][j];
                }
                if(j>0){
                    dig=dp[i-1][j-1];
                }
                dp[i][j]=triangle[i][j]+min(up,dig);


            }

        }
        int mini=INT_MAX;
        for(int j=0;j<m;j++){
            mini=min(mini,dp[n-1][j]);
        }
        return mini;
        //return 0;
    }
};