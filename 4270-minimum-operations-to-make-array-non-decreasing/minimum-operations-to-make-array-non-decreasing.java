class Solution {
    public long minOperations(int[] nums) {
        int total=0;
        long curr=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]>nums[i]){
                curr+=(nums[i-1]-nums[i]);
            }
        }
        return curr;
    }
}