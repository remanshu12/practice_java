class Solution {
    static long findcost(int[] cost,int[] nums,long mid){
        long cot=0;
        for(int i=0;i<nums.length;i++){
            cot+=(Math.abs(nums[i]-mid)*cost[i]);
        }
        return cot;
    }
    public long minCost(int[] nums, int[] cost) {
        long min = Integer.MAX_VALUE;
        long max = Integer.MIN_VALUE;
        for(int n : nums){
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        long ans=Integer.MAX_VALUE;
        long low=min;
        long high=max;
        while(low<=high){
            long mid=low+(high-low)/2;
            long cost1=findcost(cost,nums,mid);
            long cost2=findcost(cost,nums,mid+1);
            ans=Math.min(cost1,cost2);
            if(cost1>cost2){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        if(ans==Integer.MAX_VALUE){
            return 0;
        }
        return ans;
    }
}