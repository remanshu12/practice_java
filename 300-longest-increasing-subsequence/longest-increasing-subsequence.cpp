class Solution {
public:
    int helper(vector<int>& nums,int index,int pre,vector<vector<int>>& dp){
        if(index==nums.size()){
            return 0;
        }
        if(dp[index][pre+1]!=-1){
            return dp[index][pre+1];
        }
        int pick=0;
        int notpick=0;
        if(pre==-1 || nums[pre]<nums[index]){
            pick=1+helper(nums,index+1,index,dp);    
        }
        
            notpick=helper(nums,index+1,pre,dp);
        
        return dp[index][pre+1]= max(pick,notpick);

    }
    int lengthOfLIS(vector<int>& nums) {
        int n=nums.size();
        vector<vector<int>> dp(n+1,vector<int>(n+1,-1));
       return helper(nums,0,-1,dp);
    }
};