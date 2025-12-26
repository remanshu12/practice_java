class Solution {
    public int partitionDisjoint(int[] nums) {
        int min[]=new int[nums.length];
        int n=nums.length;
        min[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            min[i]=Math.min(min[i+1],nums[i]);
        }
        //System.out.println(Arrays.toString(min));
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n-1;i++){
            if(nums[i]>max){
                max=nums[i];
            }
          //  System.out.println(max+" "+min[i+1]);
            if(max<=min[i+1]){
                return i+1;
            }
        }
        return 1;
    }
}