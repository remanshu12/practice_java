class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> set=new HashSet<>();
        long sum=0;
        int left=0;
        long max=0;
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i])){
                sum+=nums[i];
                set.add(nums[i]);
            }else{
                while(set.contains(nums[i])){
                    set.remove(nums[left]);
                    sum-=nums[left];
                    left++;
                }
                sum+=nums[i];
                set.add(nums[i]);
                
            }
            if(set.size()==k){
                //System.out.println(sum);
                max=Math.max(max,sum);
                set.remove(nums[left]);
              
                sum-=nums[left];
                left++;
            }
            
        }
        return max;
    }
}