class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int vis[][]=new int[n][m];
        int dist[][]=new int[n][m];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j,0});
                    vis[i][j]=1; 
                }else{
                    vis[i][j]=0;
                }
            }
        }
        int delrow[]={-1,0,+1,0};
        int delcol[]={0,+1,0,-1};

        while(!q.isEmpty()){
            int row=q.peek()[0];
            int col=q.peek()[1];
            int steps=q.peek()[2];
            q.poll();
            dist[row][col]=steps;
            for(int i=0;i<4;i++){
                int newrow=row+delrow[i];
                int newcol=col+delcol[i];
                if(newrow>=0 && newcol>=0 && newrow<n && newcol<m && vis[newrow][newcol] ==0){
                    vis[newrow][newcol]=1;
                    q.add(new int[]{newrow,newcol,steps+1});
                }
            }
        }
        return dist;
    }
}