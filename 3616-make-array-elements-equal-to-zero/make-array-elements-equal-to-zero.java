class Solution {
    public int countValidSelections(int[] nums) {
        int pre[]=new int[nums.length];
        pre[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            pre[i]=pre[i-1]+nums[i];
        }
        int total=0;
        int count=0;
        for(int i=nums.length-1;i>=0;i--){
            total+=nums[i];
            if(total==pre[i] && nums[i]==0){
                count+=2;
            }else if(nums[i]==0 && total-1==pre[i]){
                count++;
            }else if(nums[i]==0 && total==pre[i]-1){
                count++;
            }
        }
        return count;
    }
}