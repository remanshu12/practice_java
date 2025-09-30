class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int pre[]=new int[n];
        int max=height[0];
        for(int i=0;i<n;i++){
            max=Math.max(max,height[i]);
            pre[i]=max;
        }
         int suff[]=new int[n];
        max=height[n-1];
        for(int i=n-1;i>=0;i--){
            max=Math.max(max,height[i]);
            suff[i]=max;
        }
        int total=0;
        for(int i=0;i<n;i++){
            total+=(Math.min(pre[i],suff[i])-height[i]);
        }
    return total;
    }
}