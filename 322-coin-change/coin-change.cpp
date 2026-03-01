class Solution {
public:
    int coinChange(vector<int>& coins, int sum) {
        int n=coins.size();

        vector<vector<int>> dp(n+1,vector<int>(sum+1));
        for(int i=0;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(j==0){
                    dp[i][j]=0;
                }if(i==0){
                    dp[i][j]=INT_MAX-1;
                }
            }
        }
        
        for(int j=1;j<=sum;j++){
            cout << j/coins[0];
            if((j%coins[0])==0){
                dp[1][j]=j/coins[0];
            }else{
                dp[1][j]=INT_MAX-1;
            }
        }
        
        for(int i=2;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(j>=coins[i-1]){
                    dp[i][j]=min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        // for(int i=0;i<=n;i++){
        //     for(int j=0;j<=sum;j++){
        //         cout << dp[i][j] << " ";
        //     }
        //     cout << "hello"<<'\n';
        // }
        return dp[n][sum] == INT_MAX - 1 ? -1 : dp[n][sum];
    }
};