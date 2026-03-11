class Solution {
    static double helper(int n,int k,int row,int col,double dp[][][]){
        if(row>=n || row<0 || col>=n || col<0){
            return 0;
        }
        if(k==0){
            return 1;
        }
        if(dp[row][col][k]!=-1){
            return dp[row][col][k];
        }
        int[] rowa={-2,-2,-1,1,1,-1,2,2};
        int[] cola={1,-1,2,2,-2,-2,1,-1};
        double prob=0.0;
        for(int i=0;i<8;i++){
             prob+=helper(n,k-1,row+rowa[i],col+cola[i],dp);
        }
        return dp[row][col][k]=prob/8;
    }
    public double knightProbability(int n, int k, int row, int col) {
        double dp[][][]=new double[n+1][n+1][k+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                for(int s=0;s<=k;s++){
                    dp[i][j][s]=-1;
                }
            }
        }
       return helper(n,k,row,col,dp);
    }
}