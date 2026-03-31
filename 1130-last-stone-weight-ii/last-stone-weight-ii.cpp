class Solution {
public:
    int lastStoneWeightII(vector<int>& stones) {
        int n=stones.size();
        int sum=0;
        for(int i=0;i<stones.size();i++){
            sum+=stones[i];
        }int total=sum;
        sum=sum/2;
        sum+=1;
        vector<vector<bool>> dp(n+1,vector<bool>(sum+1));
        for(int i=0;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(i==0){
                    dp[i][j]=false;
                }
                if(j==0){
                    dp[i][j]=true;
                }
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(j>=stones[i-1]){
                    dp[i][j]=dp[i-1][j]|| dp[i-1][j-stones[i-1]];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        int ans=INT_MAX;
        for(int j=0;j<=sum;j++){
            if(dp[n][j]){
                cout<<j<<endl;
                ans=min(ans,abs((total-j)-j));
            }
        }
        return ans;
    }
};