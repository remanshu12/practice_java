class Solution {
    public int[] separateDigits(int[] nums) {
      String str="";
      for(int i=0;i<nums.length;i++){
        str+=nums[i];
      }
      int[] ans=new int[str.length()];
      for(int i=0;i<ans.length;i++){
        char ch=str.charAt(i);
        ans[i]=ch-'0';
      }
      return ans;
    }
}