class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean visited[][]=new boolean[n][m];
        visited[0][0]=true;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{grid[0][0],0,0});
         int rowArr[]={-1,1,0,0};
        int colArr[]={0,0,-1,1};
int max=grid[0][0];
        while(!pq.isEmpty()){
            int row=pq.peek()[1];
            int col=pq.peek()[2];
            int dis=pq.peek()[0];
            pq.poll();
                if(row==n-1 && col==m-1){
                return dis;
            }
            for(int i=0;i<4;i++){
                int newrow=row+rowArr[i];
                int newcol=col+colArr[i];
                if(newrow>=0 && newcol>=0 && newrow<n && newcol<m && visited[newrow][newcol]!=true){
                    visited[newrow][newcol]=true;
                    max=Math.max(dis,grid[newrow][newcol]);
                 
                    pq.add(new int[]{max,newrow,newcol});
                }
            }

        }
        return -1;
    }
}