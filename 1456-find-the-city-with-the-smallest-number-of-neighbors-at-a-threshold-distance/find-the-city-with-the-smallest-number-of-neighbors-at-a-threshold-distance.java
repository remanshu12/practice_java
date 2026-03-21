class Solution {
    public int findTheCity(int n, int[][] edges, int df) {
       
        
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],(int)1e9);
        }
        for(int i=0;i<n;i++){
            dp[i][i]=0;
        }
        for(int it[]:edges){
            int u=it[0];
            int v=it[1];
            int w=it[2];
            dp[u][v]=w;
            dp[v][u]=w;
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k][j]);
                }
            }
        }
        int count=0;
        int ans=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            count=0;
                for(int j=0;j<n;j++){
                    if(dp[i][j]<=df)
                   count++;
                }
                if(count<=min){
                    min=count;
                    ans=i;
                }

        }
        
        return ans;
    }
}