class Solution {
public:
    // long long helper(vector<int>& nums,int index,bool check){
    //     if(index>=nums.size()){
    //         return 0;
    //     }
    //     long long pick=0;
    //     long long notpick=0;
        
    //     notpick=helper(nums,index+1,check);
    //     if(check==true){
    //         pick=nums[index]+helper(nums,index+1,false);   
    //     }else{
    //         pick=-nums[index]+helper(nums,index+1,true);  
    //     }
    //     return max(pick,notpick);

    // }
    long long maxAlternatingSum(vector<int>& nums) {
        int n=nums.size();
        vector<vector<long long>> dp(n+1,vector<long long>(2,0));
      // return helper(nums,0,true);
      for(int i=n-1;i>=0;i--){
        for(int j=0;j<=1;j++){
            dp[i][j]=dp[i+1][j];
            if(j==0){
                dp[i][j]=max(dp[i][j],nums[i]+dp[i+1][1]);
            }else{
                dp[i][j]=max(dp[i][j],-nums[i]+dp[i+1][0]);
            }
        }
      }
      return dp[0][0];
    }
};