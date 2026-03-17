class Solution {
    public int minimumObstacles(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean visited[][]=new boolean[n][m];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
      //  int obs=0;
      visited[0][0]=true;
        int rowArr[]={-1,1,0,0};
        int colArr[]={0,0,-1,1};
        pq.add(new int[]{grid[0][0],0,0});
        int min=Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            int obs=pq.peek()[0];
            int row=pq.peek()[1];
            int col=pq.peek()[2];
            if(row==n-1 && col==m-1){
                min=Math.min(min,obs);
            }
            pq.poll();
            for(int i=0;i<4;i++){
                int newrow=row+rowArr[i];
                int newcol=col+colArr[i];
                if(newrow>=0 && newcol>=0 && newrow<n && newcol<m && visited[newrow][newcol]!=true){
                    visited[newrow][newcol]=true;
                    pq.add(new int[]{obs+grid[newrow][newcol],newrow,newcol});
                }
            }
        }
        return min;
        
    }
}