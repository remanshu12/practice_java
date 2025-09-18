 class tuple{
            int first;
            int second;
            int third;
            tuple(int f,int s,int t){
                first=f;
                second=s;
                third=t;
            }
            
        }
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
       Queue<tuple> pq=new LinkedList<>();
      
        int n=grid.length;
        int m=grid[0].length;
           

        // If start or end blocked
        if (grid[0][0] == 1 || grid[n-1][m-1] == 1) return -1;

        // Single cell case
        if (n == 1 && m == 1) return 1;
        int dist[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=(int)1e9;
            }
        } 
        dist[0][0]=1;
        pq.add(new tuple(1,0,0));
        int dr[]={-1,-1,0,+1,+1,+1,0,-1};
        int dc[]={0,+1,+1,+1,0,-1,-1,-1};
        while(!pq.isEmpty()){
            int dis=pq.peek().first;
            int r=pq.peek().second;
            int c=pq.peek().third;
            pq.poll();
            for(int i=0;i<8;i++){
                int newrow=r+dr[i];
                int newcol=c+dc[i];
                if(newrow>=0 && newrow<n && newcol>=0 && newcol<m && grid[newrow][newcol]==0 && dis+1<dist[newrow][newcol]){
                    dist[newrow][newcol]=dis+1;
                    if(newrow==n-1 && newcol==m-1){
                        return dis+1;
                    }
                    pq.add(new tuple(dis+1,newrow,newcol));
                }
            }
        }
        return -1;
    }
}