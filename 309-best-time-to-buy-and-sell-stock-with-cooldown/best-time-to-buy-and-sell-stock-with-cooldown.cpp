class Solution {
public:
    int helper(vector<int>& prices,int index,int buy,vector<vector<int>>& dp){
        if(index>=prices.size()){
            return 0;
        }
        if(dp[index][buy]!=-1){
            return dp[index][buy];
        }
        int profit=0;
        if(buy==0){
            profit=max(-prices[index]+helper(prices,index+1,1,dp),helper(prices,index+1,0,dp));
        }else{
            profit=max(prices[index]+helper(prices,index+2,0,dp),helper(prices,index+1,1,dp));
        }
        return dp[index][buy]= profit;
        
    }
    int maxProfit(vector<int>& prices) {
        int n=prices.size();
        vector<vector<int>> dp(n+1,vector<int>(2,-1));
      return helper(prices,0,0,dp); 
    }
};