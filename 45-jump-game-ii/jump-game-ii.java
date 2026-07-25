class Solution {
    public int jump(int[] nums) {
        int max=nums[0];
        int count=0; 
        for(int i=1;i<nums.length;){
            int temp=0;
            while(i<=max && i<nums.length){
                temp=Math.max(temp,i+nums[i]);
                i++;
            }     
            count++;     
            max=temp;                            
        }
        return count;
        }
}