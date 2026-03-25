class Solution {
    public int maxJumps(int[] arr, int d) {
        int n=arr.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
    int max=1;
    for(int i=0;i<n;i++){
        max=Math.max(max,dfs(arr,d,i,n,dp));
    }
    return max;
    }
    static int dfs(int[] arr,int d,int i,int n,int[] dp){
        int jump=1;
        if(dp[i]!=-1) return dp[i];
        for(int j=i-1;j>=i-d;j--){
            if(j<0) continue;
            if(arr[i]>arr[j]){
                jump=Math.max(jump,1+dfs(arr,d,j,n,dp));
            }else{
                break;
            }
        }
        for(int j=i+1;j<=i+d;j++){
            if(j>=n) continue;
            if(arr[i]>arr[j]){
                jump=Math.max(jump,1+dfs(arr,d,j,n,dp));
            }else{
                break;
            }
        }
        return dp[i]=jump;
    }
}