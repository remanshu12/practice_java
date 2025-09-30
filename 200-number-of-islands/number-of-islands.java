class Solution {
     static class pair{
        int first;
        int second;
        pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] visited=new int[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0 && grid[i][j]=='1'){
                    count++;
                    bfs(visited,i,j,n,m,grid);
                }
            }
        }
        return count;
    }
    static void bfs(int[][] visited,int row,int col,int n,int m,char[][] grid ){
        int[] delrow={-1,0,1,0};
        int[] delcol={0,1,0,-1};
        visited[row][col]=1;
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(row,col));
        while(!q.isEmpty()){
             row=q.peek().first;
             col=q.peek().second;
            q.poll();
        for(int i=0;i<4;i++){
            int newrow=row+delrow[i];
            int newcol=col+delcol[i];
            if(newrow>=0 && newrow<n && newcol>=0 && newcol<m && visited[newrow][newcol]==0 && grid[newrow][newcol]=='1'){
                visited[newrow][newcol]=1;
                q.add(new pair(newrow,newcol));
            }
        }
     }
    }
}