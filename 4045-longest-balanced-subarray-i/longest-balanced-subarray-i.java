class Solution {
    public int longestBalanced(int[] nums) {
        int even=0;
        int odd=0;
        int max=Integer.MIN_VALUE;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            even=0;
            odd=0;
         set=new HashSet<>();

        for(int j=i;j<nums.length;j++){
                if(!set.contains(nums[j])){
                    if(nums[j]%2==0){
                        even++;
                    }else{
                        odd++;
                    }
                   
                    set.add(nums[j]);
                }
                 if(even==odd){
                        max=Math.max(j-i+1,max);
                    }
            
        }}
        return max==Integer.MIN_VALUE?0:max;
    }
}