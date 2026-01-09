class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        int m=arr.length;
        int n=arr[0].length;
         int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
       return solve(m,n,0,0,dp,arr);

        
    }
    static int solve(int m,int n,int i,int j,int dp[][],int arr[][]){
        if(i==m-1 && j==n-1 && arr[i][j]!=1){
            return 1;
        }
        if(i>=m || j>=n || arr[i][j]==1){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
       dp[i][j]= solve(m,n,i+1,j,dp,arr)+solve(m,n,i,j+1,dp,arr);
        return dp[i][j];
    }
}