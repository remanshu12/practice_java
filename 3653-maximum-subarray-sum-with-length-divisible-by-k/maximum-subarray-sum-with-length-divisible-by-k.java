class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n=nums.length;
        long prefix[]=new long[n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        long result=Long.MIN_VALUE;
        for(int start=0;start<k;start++){
            long currsum=0;
            int i=start;
            while(i<n && i+k-1 <n){
               int j=i+k-1;
                long subsum=prefix[j]-((i>0)?prefix[i-1]:0);
                currsum=Math.max(subsum,currsum+subsum);
                result=Math.max(currsum,result);
                i=i+k;
            }

        }
        return result;
    }
}