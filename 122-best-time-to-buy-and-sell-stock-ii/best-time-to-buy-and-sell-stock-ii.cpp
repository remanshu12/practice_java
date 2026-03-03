class Solution {
public:
    // int helper(int index,vector<int>& prices,int buy ,vector<vector<int>>& dp){
    //     if(index==prices.size()){
    //         return 0;
    //     }
    //     if(dp[index][buy]!=-1){
    //         return dp[index][buy];
    //     }
    //     int profit=0;
    //     if(buy==0){
    //         profit=max(-prices[index]+(helper(index+1,prices,1,dp)),
    //                         helper(index+1,prices,0,dp));
    //     }else{
    //         profit=max(prices[index]+helper(index+1,prices,0,dp),helper(index+1,prices,1,dp));
    //     }
    //     return dp[index][buy]= profit;
    // }
    int maxProfit(vector<int>& prices) {
        int n=prices.size();
        vector<vector<int>> dp(n+1,vector<int>(2,0));
        for(int i=n-1;i>=0;i--){
            for(int j=1;j>=0;j--){
                if(j==0)
                dp[i][j]=max(-prices[i]+dp[i+1][1],dp[i+1][0]);
                else
                dp[i][j]=max(prices[i]+dp[i+1][0],dp[i+1][1]);

                
            }
        }
        return dp[0][0];
      
    }
};