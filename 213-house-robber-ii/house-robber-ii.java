class Solution {
    public int rob(int[] nums) {
        int n= nums.length;
        if (n == 1) return nums[0];
        int [] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        int [] dp1 = new int[nums.length];
        Arrays.fill(dp1,-1);
        return Math.max (robber(nums,0,n-1,dp),robber(nums,1,n,dp1));
    }
    public int robber ( int [] arr , int i ,int j, int dp[]) {
        if(i>=j){
            return 0;
        }
        if(dp[i]!=-1){ // because 0 can be the answer
            return dp[i];
        }
        int rob =arr[i]+robber(arr,i+2,j,dp);
        int dont_rob = robber(arr,i+1,j,dp);
        return dp[i]= Math.max(rob , dont_rob);
    }
}