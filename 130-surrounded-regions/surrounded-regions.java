class Solution {
    public void solve(char[][] grid) {
         int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if( i==0 || j==0 || i==n-1|| j==m-1){
                   if(grid[i][j]=='O'){
                dfs(i,j,grid,n,m);}
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='#'){
                    grid[i][j]='O';
                }else{
                    grid[i][j]='X';
                }
            }
        }

        
    }
    static void dfs(int row,int col,char[][] grid,int n ,int m){
        if(row<0 || col <0 ||row>=n  || col>=m || grid[row][col]!='O'){
            return;
        }
        grid[row][col]='#';
       dfs(row+1,col,grid,n,m);
       dfs(row-1,col,grid,n,m);
       dfs(row,col+1,grid,n,m);
       dfs(row,col-1,grid,n,m);
    }
}