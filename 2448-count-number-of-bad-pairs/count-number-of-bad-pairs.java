class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Long,Long> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put((long)(nums[i]-i),map.getOrDefault((long)(nums[i]-i),0L)+1L);
        }
        int n=nums.length;
        long total=(long)n*(n-1)/2;
        long sum=0;
        for(long key:map.keySet()){
            if(map.get(key)>1){
                long val=map.get(key);
                sum+=(val*(val-1)/2);
            }
        }
        return (total-sum);
    }
}