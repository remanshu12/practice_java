class Solution {
    public int jump(int[] nums) {
        int maxdis=0;
        int l=0;
        int r=0;
        int jump=0;
        while(r<nums.length-1){
            maxdis=0;
            while(l<=r){
                maxdis=Math.max(maxdis,l+nums[l]);
                l++;
            }
            l=r+1;
            r=maxdis;
            jump++;
        }
        return jump;
    }
}