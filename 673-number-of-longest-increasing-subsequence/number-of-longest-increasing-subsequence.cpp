class Solution {
public:
    int findNumberOfLIS(vector<int>& nums) {
       int n=nums.size();
        vector<int> dp(n,1);
        vector<int> count(n,1);
      //  int ans=1;
    //    int count=0;
       int maxl=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(dp[j]+1 >dp[i]){
                        dp[i]=dp[j]+1;
                        count[i]=count[j];
                    }else if(dp[i]==dp[j]+1){
                        count[i]+=count[j];
                    }
                     
                    maxl=max(maxl,dp[i]);
                }
            }
        }
           int c=0; 
        for(int i=0;i<n;i++){
             if(dp[i]==maxl){
                c+=count[i];
             }
        }
        return c;
        
    }
};