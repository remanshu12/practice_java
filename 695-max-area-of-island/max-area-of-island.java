class Solution {
    static int count=0;
    public int maxAreaOfIsland(int[][] grid) {
         int n=grid.length;
        int m=grid[0].length;
       int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    count=0;
                dfs(i,j,grid,n,m);
                max=Math.max(max,count);
                }
            }
        }
        return max;
    }
    static void dfs(int row,int col,int[][] grid,int n ,int m){
        if(row<0 || col <0 ||row>=n  || col>=m || grid[row][col]==0){
            return;
        }
        grid[row][col]=0;
        count++;
       dfs(row+1,col,grid,n,m);
       dfs(row-1,col,grid,n,m);
       dfs(row,col+1,grid,n,m);
       dfs(row,col-1,grid,n,m);
    }
}