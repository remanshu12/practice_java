class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    count++;
                dfs(i,j,grid,n,m);}
            }
        }
        return count;
    }
    static void dfs(int row,int col,char[][] grid,int n ,int m){
        if(row<0 || col <0 ||row>=n  || col>=m || grid[row][col]=='0'){
            return;
        }
        grid[row][col]='0';
       dfs(row+1,col,grid,n,m);
       dfs(row-1,col,grid,n,m);
       dfs(row,col+1,grid,n,m);
       dfs(row,col-1,grid,n,m);
    }
}