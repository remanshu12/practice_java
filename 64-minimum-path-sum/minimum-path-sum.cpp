class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        int n=grid.size();
        int m=grid[0].size();
        vector<int> prev(m,0);
        for(int i=0;i<n;i++){
            vector<int> curr(m,0);
            for(int j=0;j<m;j++){
                if(i==0 && j==0 ){
                    curr[j]=grid[i][j];
                    continue;
                }
                int up=0;
                int left=0;
                if(i>0) up=prev[j];
                else{
                    up=curr[j-1];
                }
                if(j>0) left=curr[j-1];
                else{
                    left=prev[j];
                }
                curr[j]=grid[i][j]+min(up,left);

            }prev=curr;
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         cout << dp[i][j] << " ";
        //     }
        //     cout << '\n';
        // }
        return prev[m-1];
    }
};