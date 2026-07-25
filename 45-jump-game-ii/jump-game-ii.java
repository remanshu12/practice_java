class Solution {
    public int jump(int[] nums) {
        int max=nums[0];
        if(nums.length==1) return 0;
        if(nums[0]>=nums.length-1)
        return 1;
        int count=1; 
        for(int i=1;i<nums.length;){
            int temp=0;
            while(i<=max && i<nums.length){
                temp=Math.max(temp,i+nums[i]);
                if(temp>=nums.length-1) return count+1;
                i++;
            }     
            count++;     
            max=temp;                            
        }
        return count;
        }
}