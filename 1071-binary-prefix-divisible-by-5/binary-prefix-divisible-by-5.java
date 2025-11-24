class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> lst=new ArrayList<>();
        if(nums[0]%5==0){
            lst.add(true);
        }else{
            lst.add(false);
        }
        int x=nums[0];
        for(int i=1;i<nums.length;i++){
            x=2*x+nums[i];
            x=x%5;
            if(x%5==0){
                lst.add(true);
            }else{
                lst.add(false);
            }
        }
        return lst;
    }
}