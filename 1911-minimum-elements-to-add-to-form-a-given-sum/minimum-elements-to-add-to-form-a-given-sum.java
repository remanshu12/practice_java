class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum=0;
        for(int i=0;i<nums.length;i++){
            if(Math.abs(nums[i])<=limit){
                sum+=nums[i];
            }
        }
        if(sum==goal){
            return 0;
        }
        long diff=Math.abs(goal-sum);
        if(diff%limit==0){
            return (int)(diff/(long)limit);
        }
        return (int)((diff/(long)limit)+1);

        

    }
}