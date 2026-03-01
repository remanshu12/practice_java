class Solution {
    
public:
    
    // int helper(string& s,string& t,int i,int j,vector<vector<int>>& dp){
    //     if(j==t.length()){
    //         return 1;
    //     }
    //     if(i==s.length()){
    //         return 0;
    //     }
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }
    //     int take=0;
    //     int nottake=0;
    //     if(s[i]==t[j]){
    //        take+=helper(s,t,i+1,j+1,dp); 
    //         nottake+=helper(s,t,i+1,j,dp);
    //     }else{
    //         nottake+= helper(s,t,i+1,j,dp);
    //     }
    //     return dp[i][j]=take+nottake;
    // }

    int numDistinct(string s, string t) {
        int n=s.length();
        int m=t.length();
        vector<vector<unsigned int>> dp(n+1,vector<unsigned int>(m+1,0));
        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s[i-1]==t[j-1]){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            
            }

        }
        return dp[n][m];
        
      //  return count;
    }
};