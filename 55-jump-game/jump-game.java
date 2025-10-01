class Solution {
    public boolean canJump(int[] nums) {
        int max=0;
         int i=0;
         max=nums[i]+i;
        if(max>=nums.length-1){
                 return true;
            }
            while(i<max){
                i++;
                max=Math.max(max,(nums[i]+i));
                if(max>=nums.length-1){
                    return true;
                }
            }
            return false;      
    }
}