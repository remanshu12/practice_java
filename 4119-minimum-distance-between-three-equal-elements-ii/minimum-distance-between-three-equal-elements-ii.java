class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],new ArrayList<>());
            }
            map.get(nums[i]).add(i);
            if(map.get(nums[i]).size()>=3){
                int n=map.get(nums[i]).size();
                min=Math.min(min,2*(map.get(nums[i]).get(n-1)-map.get(nums[i]).get(n-1-2)));
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}