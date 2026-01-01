class Solution {
    static int count =0;
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int visited[][]=new int[n][m];
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    count=0;
                    max=Math.max(max,dfs(i,j,n,m,visited,grid));
                }
            }
        }
        return max;
    }
    static int dfs(int ro,int co,int n,int m,int visited[][],int[][] grid){
        if(ro>=0 && co>=0 && ro<n && co<m && visited[ro][co]==0 && grid[ro][co]==1){
            visited[ro][co]=1;
            return 1+dfs(ro-1,co,n,m,visited,grid)+dfs(ro+1,co,n,m,visited,grid)+dfs(ro,co-1,n,m,visited,grid)+dfs(ro,co+1,n,m,visited,grid);
        }
        return 0;
    }
}