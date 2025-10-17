class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
         int closest = nums[0] + nums[1] + nums[2];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int j=i+1;
            int k=nums.length-1;
           
            while(j<k){
               
                int sum=(nums[i]+nums[j]+nums[k]);
                 if (Math.abs(target - sum) < Math.abs(target - closest)) {
                    closest = sum; // found closer sum
                }
                // min=Math.min(min,sum);
               if(sum>target){
                k--;
               }else if(sum<target){
                j++;}
               else{
                return sum;
             }
            }
        }
        return closest;
    }
    
}