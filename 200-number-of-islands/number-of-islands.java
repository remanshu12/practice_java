class Solution {
    static class pair{
        int first,second;
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
                    bfs(i,j,grid,visited,n,m);
                }
            }
        }
        return count;
    }
        static void bfs(int ro,int co,char[][] grid,int[][] visited,int n,int m){
            visited[ro][co]=1;
            Queue<pair> q=new LinkedList<>();
           q.add(new pair(ro,co));
           int drow[]={1,0,-1,0};
            int dcol[]={0,1,0,-1};
            while(!q.isEmpty()){
                 
            int row=q.peek().first;
            int col=q.peek().second;
            q.poll();
                
                for(int i=0;i<4;i++){
                   
                        int newrow=row+drow[i];
                        int newcol=col+dcol[i];
                        if(newrow>=0 && newcol >=0 && newrow<n && newcol<m && visited[newrow][newcol]==0 && grid[newrow][newcol]=='1'){
                            visited[newrow][newcol]=1;
                            q.add(new pair(newrow,newcol));
                        }
                    
                }
            }
        }
    
}