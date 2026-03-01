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
        vector<unsigned int> dp(m+1,0);
        dp[0]=1;
        for(int i=1;i<=n;i++){
            for(int j=m;j>0;j--){
                if(s[i-1]==t[j-1]){
                    dp[j]=dp[j]+dp[j-1];
                }
            
            }

        }
        return dp[m];
        
      //  return count;
    }
};