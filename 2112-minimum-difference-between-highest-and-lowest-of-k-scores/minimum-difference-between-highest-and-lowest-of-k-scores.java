class Solution {
    public int minimumDifference(int[] nums, int k) {
        if(k==1){
            return 0;
        }
        int min=Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i+k-1<nums.length;i++){
            min=Math.min(min,(nums[i+k-1]-nums[i]));
        }
        return min;
    }
}