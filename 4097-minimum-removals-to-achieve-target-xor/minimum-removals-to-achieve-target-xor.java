class Solution {
    static int helper(int[] nums,int target,int index,int xor,int dp[][]){
        if(index==nums.length){
            if(xor==target){
                return 0;
            }
            return -(int)1e9;
        }
        if(dp[index][xor]!=-1){
            return dp[index][xor];
        }
        int pick=1+helper(nums,target,index+1,xor^nums[index],dp);
        int notpick=helper(nums,target,index+1,xor,dp);
        return dp[index][xor]=Math.max(pick,notpick);
    }
    public int minRemovals(int[] nums, int target) {
        int n=nums.length;
        int dp[][]=new int[nums.length+1][100000];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
       int ans= helper(nums,target,0,0,dp);
      if(ans<0) return -1;
       return nums.length-ans;
    }
}