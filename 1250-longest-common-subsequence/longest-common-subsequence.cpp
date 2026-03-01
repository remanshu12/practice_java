class Solution {
public:
    int helper(string& text1,string& text2,int i,int j,vector<vector<int>>& dp){
        if(i>=text1.length() || j>=text2.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int take=0;
        int left=0;
        int right=0;
        if(text1[i]==text2[j]){
            take= 1+helper(text1,text2,i+1,j+1,dp);
        }else{
             left=helper(text1,text2,i+1,j,dp);
             right=helper(text1,text2,i,j+1,dp);
        }
        return dp[i][j]=take+max(left,right);
    }
    int longestCommonSubsequence(string text1, string text2) {
        int n=text1.length();
        int m=text2.length();
        vector<vector<int>> dp(n+1,vector<int>(m+1,-1));
       return helper(text1,text2,0,0,dp);
    }
};