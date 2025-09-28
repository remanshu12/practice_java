class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int flag=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                flag=1;
                break;
            }
        }
        if(flag==0){
            Arrays.sort(nums);
            return nums[nums.length-1];
        }
        int total=nums[0];
        int minsum=nums[0];
        int maxsum=nums[0];
        for(int i=1;i<nums.length;i++){
            total+=nums[i];
            if(minsum>0){
                minsum=0;
            }
            if(maxsum<0){
                maxsum=0;
            }
            min=Math.min(min,minsum);
            max=Math.max(max,maxsum);
            minsum+=nums[i];
            maxsum+=nums[i];
        }
        if(max>total-min){
            return max;
        }
        return total-min;
    }
}