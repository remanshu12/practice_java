class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i=0;
        int j=nums.length-1;
        int sum=0;
        while(i<j){
            sum=nums[i]+nums[j];
            if(sum>target){
                j--;
            }else if(sum<target){
                i++;
            }else{
                return new int[]{i+1,j+1};
            }
        }
        return new int[]{-1,-1};
    }
}