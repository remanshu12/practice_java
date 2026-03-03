class Solution {
public:
    int helper(int index,vector<int>& prices,int buy ,vector<vector<int>>& dp){
        if(index==prices.size()){
            return 0;
        }
        if(dp[index][buy]!=-1){
            return dp[index][buy];
        }
        int profit=0;
        if(buy==0){
            profit=max(-prices[index]+(helper(index+1,prices,1,dp)),
                            helper(index+1,prices,0,dp));
        }else{
            profit=max(prices[index]+helper(index+1,prices,0,dp),helper(index+1,prices,1,dp));
        }
        return dp[index][buy]= profit;
    }
    int maxProfit(vector<int>& prices) {
        int n=prices.size();
        vector<vector<int>> dp(n+1,vector<int>(2,-1));
       return helper(0,prices,0,dp);
    }
};