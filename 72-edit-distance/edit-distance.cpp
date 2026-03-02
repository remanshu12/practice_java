class Solution {
public:
    int helper(int i,int j,string& word1,string& word2,vector<vector<int>>& dp){
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(word1[i]==word2[j]){
          return dp[i][j]= helper(i-1,j-1,word1,word2,dp);
        }
        
        int insert=1+helper(i,j-1,word1,word2,dp);
        int replace=1+helper(i-1,j-1,word1,word2,dp);
        int delet =1+helper(i-1,j,word1,word2,dp);
        return dp[i][j]= min(insert,min(replace,delet));

    }
    int minDistance(string word1, string word2) {
        int n=word1.length();
        int m=word2.length();
        vector<vector<int>> dp(n+1,vector<int>(m+1,-1));
       return helper(n,m,word1,word2,dp);
    }
};