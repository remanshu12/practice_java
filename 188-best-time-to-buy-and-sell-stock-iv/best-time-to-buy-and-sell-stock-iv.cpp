class Solution {
public:
    int maxProfit(int limit, vector<int>& prices) {
        int n=prices.size();
        vector<vector<vector<int>>> dp(n+1,vector<vector<int>>(2,vector<int>(limit+1,0)));
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=1;j++){
                for(int k=0;k<limit;k++){
                 if(j==0){
                        dp[i][j][k]=max(-prices[i]+dp[i+1][1][k],dp[i+1][0][k]);
                }else {
                         dp[i][j][k]=max(prices[i]+dp[i+1][0][k+1],dp[i+1][1][k]);
                }   
                }
            }
        }
        return dp[0][0][0];
    }
};