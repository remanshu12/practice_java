class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int prefix[] =new int[n+1];
        int suffix[]=new int[n+2];
        prefix[0]=1;
        suffix[n+1]=1;
        for(int i=1;i<=n;i++){
            prefix[i]=prefix[i-1]*nums[i-1];
        }
        suffix[n]=nums[n-1];
        for(int i=n-1;i>0;i--){
            suffix[i]=suffix[i+1]*nums[i-1];
        }
        System.out.println(Arrays.toString(prefix));
         System.out.println(Arrays.toString(suffix));
       int ans[]=new int[n];
       for(int i=0;i<n;i++){
            ans[i]=prefix[i]*suffix[i+2];
       }
         return ans;

    }
}