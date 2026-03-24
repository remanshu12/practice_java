class Solution {
    public boolean canJump(int[] nums) {
        int i=0;
        int j=0;
        while(j<=i){
            i=Math.max(j+nums[j],i);
            if(i>=nums.length-1){
                return true;
            }
            j++;
        }
        return false;
    }
}