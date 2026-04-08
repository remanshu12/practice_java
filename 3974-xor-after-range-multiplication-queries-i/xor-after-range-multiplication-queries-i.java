class Solution {
    public int xorAfterQueries(int[] nums, int[][] q) {
        long mod=1000000007;
        long ans[]=new long[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i]=nums[i];
        }
        
        for(int i=0;i<q.length;i++){
            int idx=q[i][0];
            int last=q[i][1];
            int step=q[i][2];
            int fac=q[i][3];
            for(int j=idx;j<=last;j+=step){
                ans[j]=(ans[j]*fac)%mod;
            }
        }
        long xor=0;
        for(long i:ans){
            xor=(xor^i);
        }
        return (int)xor;
    }
}