class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int[][] dp=new int[m+1][n+1];
       for (int i = 0; i <= m; i++) {
    Arrays.fill(dp[i], -1);
}
        return helper(text1,text2,m,n,dp);

    }
    int helper(String s1,String s2,int m,int n,int dp[][]){
        if(n==0 || m==0){
           return 0;
        }
    if(dp[m][n]!=-1){
        return dp[m][n];
            }
        if(s1.charAt(m-1)==s2.charAt(n-1)){
          return dp[m][n]=1+helper(s1,s2,m-1,n-1,dp);
        }
        else{
           return dp[m][n]=Math.max(helper(s1,s2,m-1,n,dp),helper(s1,s2,m,n-1,dp));
        }
    }
}