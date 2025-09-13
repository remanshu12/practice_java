class Solution {
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        int delrow[]={-1,0,+1,0};
        int delcol[]={0,+1,0,-1};
        for(int j=0;j<m;j++){

            if(vis[0][j]==0 && grid[0][j]==1){
                dfs(0,j,vis,grid,delrow,delcol);
            }

            if(vis[n-1][j]==0 && grid[n-1][j]==1){
                dfs(n-1,j,vis,grid,delrow,delcol);
            }
        }
        for(int i=0;i<n;i++){

            if(vis[i][0]==0 && grid[i][0]==1){
                dfs(i,0,vis,grid,delrow,delcol);
            }

            if(vis[i][m-1]==0 && grid[i][m-1]==1){
                dfs(i,m-1,vis,grid,delrow,delcol);
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    static void dfs(int row,int col,int[][] vis,int[][] grid,int[] delrow,int[] delcol){
        int n=grid.length;
        int m=grid[0].length;
        vis[row][col]=1;
        for(int i=0;i<4;i++){
            int newrow=row+delrow[i];
            int newcol=col+delcol[i];
            if(newrow>=0 && newrow<n && newcol>=0 && newcol<m && vis[newrow][newcol]==0 && grid[newrow][newcol]==1 ){
                dfs(newrow,newcol,vis,grid,delrow,delcol);
            }
        }
    }
}