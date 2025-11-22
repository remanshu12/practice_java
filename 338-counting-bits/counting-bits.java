class Solution {
    public int[] countBits(int n) {
        int dp[]=new int[n+1];
        if(n==0){
            dp[0]=0;
            return dp;
        }else if(n==1){
            dp[0]=0;
            dp[1]=1;
            return dp;
        }else if(n==2){
            dp[0]=0;
            dp[1]=1;
            dp[2]=1;
            return dp;
        }
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        int temp=2;
        for(int i=3;i<=n;i++){
            if(((i)&(i-1))==0){
                dp[i]=1;
                temp=i;
            }else{
                dp[i]=dp[temp]+dp[i-temp];
            }
        }
        return dp;
    }
}