class Solution {
    
public:
    
    int helper(string& s,string& t,int i,int j,vector<vector<int>>& dp){
        if(j==t.length()){
            return 1;
        }
        if(i==s.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int take=0;
        int nottake=0;
        if(s[i]==t[j]){
           take+=helper(s,t,i+1,j+1,dp); 
            nottake+=helper(s,t,i+1,j,dp);
        }else{
            nottake+= helper(s,t,i+1,j,dp);
        }
        return dp[i][j]=take+nottake;
    }

    int numDistinct(string s, string t) {
        int n=s.length();
        int m=t.length();
        vector<vector<int>> dp(n+1,vector<int>(m+1,-1));
       return helper(s,t,0,0,dp);
        
      //  return count;
    }
};