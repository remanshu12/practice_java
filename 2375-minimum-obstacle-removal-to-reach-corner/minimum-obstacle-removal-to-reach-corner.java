class Solution {
    public int minimumObstacles(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int dist[][]=new int[n][m];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
      //  int obs=0;
      for(int i=0;i<n;i++){
        Arrays.fill(dist[i],Integer.MAX_VALUE);
      }
      dist[0][0]=0;
        int rowArr[]={-1,1,0,0};
        int colArr[]={0,0,-1,1};
        pq.add(new int[]{grid[0][0],0,0});
        int min=Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            int obs=pq.peek()[0];
            int row=pq.peek()[1];
            int col=pq.peek()[2];
            if(row==n-1 && col==m-1){
                return obs;
            }
            pq.poll();
            for(int i=0;i<4;i++){
                int newrow=row+rowArr[i];
                int newcol=col+colArr[i];
                if(newrow>=0 && newcol>=0 && newrow<n && newcol<m){
                  if(dist[newrow][newcol]>obs+grid[newrow][newcol]){
                    dist[newrow][newcol]=obs+grid[newrow][newcol];
                    pq.add(new int[]{obs+grid[newrow][newcol],newrow,newcol});
                  }
                    
                }
            }
        }
        return -1;
        
    }
}