class Solution {
    public int shortestPath(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        int max[][]=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(max[i],-1);
        }
        max[0][0]=k;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,0,k,0});
        int rowArr[]={-1,1,0,0};
        int colArr[]={0,0,-1,1};
        while(!q.isEmpty()){
            int row=q.peek()[0];
            int col=q.peek()[1];
            int steps=q.peek()[2];
            int dis=q.peek()[3];
            q.poll();
            if(row==n-1 && col==m-1){
                return dis;
            }
            for(int i=0;i<4;i++){
                int newrow=row+rowArr[i];
                int newcol=col+colArr[i];
                if(newrow>=0 && newcol>=0 && newrow<n && newcol<m){
                   int  newsteps=steps-grid[newrow][newcol];
                    if(newsteps>=0 && max[newrow][newcol]<newsteps){
                        max[newrow][newcol]=steps;
                        q.add(new int[]{newrow,newcol,newsteps,dis+1});
                    }
                }
            }
        }
        return -1;
    }
}