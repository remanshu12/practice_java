class Solution {
    public int partitionArray(int[] nums, int k) {
        int i=0;
        int j=0;
        Arrays.sort(nums);
        int count=1;
        while(j<nums.length){
            if(Math.abs(nums[i]-nums[j])<=k){
                j++;
            }else{
                count++;
                i=j;
            }
        }
        return count;
    }
}