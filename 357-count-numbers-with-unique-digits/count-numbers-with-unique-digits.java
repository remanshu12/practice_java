class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0){
            return 1;
        }
        if(n==1){
            return 10;
        }
          int dp[]=new int[n+1];
        int ans=91;
        dp[2]=81;
      
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]*(11-i);
            ans+=dp[i];
        }
        return ans;
    }
}