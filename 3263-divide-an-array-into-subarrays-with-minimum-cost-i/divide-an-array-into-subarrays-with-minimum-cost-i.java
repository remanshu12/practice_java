class Solution {
    public int minimumCost(int[] nums) {
        int total=0;
        total=nums[0];
       ArrayList<Integer> list=new ArrayList<>();
       for(int i=1;i<nums.length;i++){
        list.add(nums[i]);
       }
       Collections.sort(list);
       return total+list.get(0)+list.get(1);
    }
}