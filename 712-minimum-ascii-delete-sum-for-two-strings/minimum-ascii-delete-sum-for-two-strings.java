class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int dp[][]=new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<=s1.length();i++){
            for(int j=0;j<=s2.length();j++){
                dp[i][j]=-1;
            }
        }
       return solve(0,0,s1,s2,dp);
    }
    static int solve(int i,int j,String s1,String s2,int[][] dp){
        if(i>=s1.length() && j>=s2.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(i>=s1.length()){
            return dp[i][j]=s2.charAt(j)+solve(i,j+1,s1,s2,dp);
        }
        else if(j>=s2.length()){
            return dp[i][j]=s1.charAt(i)+solve(i+1,j,s1,s2,dp);
        }
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]= solve(i+1,j+1,s1,s2,dp);
        }
        int delete=s1.charAt(i)+solve(i+1,j,s1,s2,dp);
        int not=s2.charAt(j)+solve(i,j+1,s1,s2,dp);
        return dp[i][j] =Math.min(delete,not);
    
    }
}