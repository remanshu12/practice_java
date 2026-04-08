class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0;
        int x=0;
        for(int i=0;i<nums.length;i++){
            x+=nums[i];
            if(map.containsKey(((x%k)+k)%k)){
                sum+=map.get(((x%k)+k)%k);
            }
            map.put(((x%k)+k)%k,map.getOrDefault(((x%k)+k)%k,0)+1);
        }
        return sum;
    }
}