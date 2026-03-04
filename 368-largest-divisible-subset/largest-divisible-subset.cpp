class Solution {
public:
    vector<int> largestDivisibleSubset(vector<int>& nums) {
        int n=nums.size();
        sort(nums.begin(),nums.end());
        vector<int> dp(n,1);
        int maxl=1;
         vector<int> prev(n,-1);
         int lastindex=0;
         for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0){
                    if(1+dp[j]>dp[i]){
                        prev[i]=j;
                    }
                    dp[i]=max(dp[i],1+dp[j]);
                    if(dp[i]>maxl){
                        maxl=dp[i];
                        lastindex=i;
                    }
                }
            }
         }
         vector<int> res;
         while(lastindex!=-1){
            res.push_back(nums[lastindex]);
            lastindex=prev[lastindex];
         }
         return res;

    }
};