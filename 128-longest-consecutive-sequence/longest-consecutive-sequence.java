class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int max=0;
        int count=0;
        if(nums.length==0) return 0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]-nums[i]==0) continue;
            if(nums[i+1]-nums[i]==1){
                count++;
            }else{
                max=Math.max(max,count+1);
                count=0;
            }
            
        }
         max=Math.max(max,count+1);
        return max;
    }
}