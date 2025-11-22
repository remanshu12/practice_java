class Solution {
    public int rob(int[] nums) {
      if(nums.length<2){
        return nums[0];
      }
      if(nums.length==2){
        return Math.max(nums[0],nums[1]);
      }
    //  System.out.println(helper(nums,0,nums.length-1));
      return Math.max(helper(nums,0,nums.length-1),helper(nums,1,nums.length));

     
    }
    static int helper(int[] nums,int i,int j){
         int arr[]=new int[nums.length];
      arr[i]=nums[i];
      arr[i+1]=Math.max(nums[i],nums[i+1]);
      for( i=i+2;i<j;i++){
      arr[i]=Math.max(arr[i-2]+nums[i],arr[i-1]);
      }
     System.out.println(Arrays.toString(arr));
      return arr[j-1];
    }
}