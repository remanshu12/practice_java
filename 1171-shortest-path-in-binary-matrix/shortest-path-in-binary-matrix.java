class Solution {
    class polak{
        int first;
        int second;
        int third;
        polak(int f,int s,int t){
            first=f;
            second=s;
            third=t;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] dist=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=(int)1e9;
            }
        }
        if(grid[0][0]==1 || grid[n-1][m-1]==1){
            return -1;
        }
        if(n==1 && m==1){
            return 1;
        }
        
        dist[0][0]=1;
        Queue<polak> q=new LinkedList<>();
        q.add(new polak(1,0,0));
        while(!q.isEmpty()){
            int dis=q.peek().first;
            int row=q.peek().second;
            int col=q.peek().third;
            q.poll();
            int drow[]={-1,-1,-1,0,0,+1,1,1};
            int dcol[]={-1,0,1,-1,+1,-1,0,1};
            for(int i=0;i<8;i++){
                int newrow=row+drow[i];
                int newcol=col+dcol[i];
                if(newrow>=0 && newcol>=0 && newrow<n && newcol<m && grid[newrow][newcol]==0 && dis+1<dist[newrow][newcol]){
                    dist[newrow][newcol]=dis+1;
                    if(newrow==n-1 && newcol==m-1){
                        return dis+1;
                    }
                    q.add(new polak(dis+1,newrow,newcol));
                }
            }
        }
        return -1;
    }
}