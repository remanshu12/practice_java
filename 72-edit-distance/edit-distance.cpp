class Solution {
public:
    // int helper(int i,int j,string& word1,string& word2,vector<vector<int>>& dp){
    //     if(i<0) return j+1;
    //     if(j<0) return i+1;
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }
    //     if(word1[i]==word2[j]){
    //       return dp[i][j]= helper(i-1,j-1,word1,word2,dp);
    //     }
        
    //     int insert=1+helper(i,j-1,word1,word2,dp);
    //     int replace=1+helper(i-1,j-1,word1,word2,dp);
    //     int delet =1+helper(i-1,j,word1,word2,dp);
    //     return dp[i][j]= min(insert,min(replace,delet));

    // }
    int minDistance(string word1, string word2) {
        int n=word1.length();
        int m=word2.length();
        vector<vector<int>> dp(n+1,vector<int>(m+1,0));
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0){
                    dp[i][j]=j;
                }
                if(j==0){
                    dp[i][j]=i;
                }
            }
        }
        dp[0][0]=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(word1[i-1]==word2[j-1]){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=min(1+dp[i-1][j],min(1+dp[i-1][j-1],1+dp[i][j-1]));
                }
            }
        }
        return dp[n][m];
    }
};