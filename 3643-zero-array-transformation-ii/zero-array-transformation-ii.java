class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int low=0;
        boolean alreadyZero = true;
        for(int x : nums) if(x > 0) alreadyZero = false;
        if(alreadyZero) return 0;
        int high=queries.length-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(check(mid,nums,queries)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans==-1?-1:ans+1;
    }
     boolean check(int last ,int nums[],int[][] que){
        int n=nums.length;
        long ans[]=new long[n+1];
        for(int i=0;i<=last;i++){
            int a=que[i][0];
            int b=que[i][1];
            int val=que[i][2];
            ans[a]+=val;
            ans[b+1]+=-val;
        }
        for(int i=0;i<n;i++){
            if(i>0)
            ans[i]=ans[i]+ans[i-1];
            if(nums[i]>ans[i]){
                return false;
            }
        }
        return true;
    }
}