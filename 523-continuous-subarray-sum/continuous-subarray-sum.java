class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        long sum=0;
        sum+=nums[0];
         HashMap<Long,Long> map=new HashMap<>();
         if(!map.containsKey(sum%k))
              map.put(sum%k,(long)0);
       
        map.put(0L,-1L);
        for(int i=1;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum%k) && i-map.get(sum%k)>1){
                return true;
            }
            if(!map.containsKey(sum%k))
              map.put(sum%k,(long)i);
        }
        return false;

    }
}