class Solution {
public:
    int helper(vector<int>& prices,int index,int buy,int count,vector<vector<vector<int>>>& dp){
        if(index==prices.size() || count>=2){
            return 0;
        }
        if(dp[index][buy][count]!=-1){
            return dp[index][buy][count];
        }
        int profit=0;
        if(buy==0){
            profit=max(-prices[index]+helper(prices,index+1,1,count,dp),helper(prices,index+1,0,count,dp));
        }else {
            profit=max(prices[index]+helper(prices,index+1,0,count+1,dp),helper(prices,index+1,1,count,dp));
        }
        return dp[index][buy][count]=profit;
    }
    int maxProfit(vector<int>& prices) {
        int n=prices.size();
        vector<vector<vector<int>>> dp(n+1,vector<vector<int>>(2,vector<int>(2,-1)));
        return helper(prices,0,0,0,dp);
      
    }
};