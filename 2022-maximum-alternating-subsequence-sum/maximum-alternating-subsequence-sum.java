class Solution {
    public long maxAlternatingSum(int[] nums) {   
        int flag=0;
        long dp[][]=new long[nums.length][2];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<2;j++){
                dp[i][j]=-1;
            }
        }
       return solve(nums,0,flag,dp);
        
    }
    static long solve(int[] nums,int i,int flag,long[][] dp){
        if(i==nums.length){
            return 0;
        }
        long pick=0;
        long notpick=0;
        if(dp[i][flag]!=-1){
            return dp[i][flag];
        }
        if(flag==0){
             pick=nums[i]+solve(nums,i+1,flag+1,dp);
        }else{
             pick=-nums[i]+solve(nums,i+1,flag-1,dp);
        }
        notpick=solve(nums,i+1,flag,dp);
        return dp[i][flag]=Math.max(pick,notpick);
    }
}