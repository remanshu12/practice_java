class tuple{
    int dis;
    int row;
    int col;
    tuple(int d,int r,int c){
        dis=d;
        row=r;
        col=c;
    }
}
class Solution {
    public int minimumEffortPath(int[][] height) {
        PriorityQueue<tuple> pq=new PriorityQueue<>((a,b)-> a.dis-b.dis);
        int n=height.length;
        int m=height[0].length;
        int dist[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=(int)1e9;
            }
        }
        dist[0][0]=0;
        pq.add(new tuple(0,0,0));
        int dr[]={-1,0,1,0};
        int dc[]={0,1,0,-1};

        while(pq.size()!=0){
            tuple it=pq.poll();
            int diff=it.dis;
            int row=it.row;
            int col=it.col;

            if(row==n-1 && col== m-1){
                return diff;
            }

            for(int i=0;i<4;i++){
                int newrow=row+dr[i];
                int newcol=col+dc[i];
                if(newrow>=0 && newcol>=0 && newrow<n && newcol<m){
                    int neweffort=Math.max(Math.abs(height[row][col]-height[newrow][newcol]),diff);
                    if(neweffort<dist[newrow][newcol]){
                        dist[newrow][newcol]=neweffort;
                        pq.add(new tuple(neweffort,newrow,newcol));
                    }
                }
            }
        }
        return 0;

    }
}