class Solution {
    public int minimumEffortPath(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,0,0});
        int[] rowArr={-1,1,0,0};
        int[] colArr={0,0,1,-1};
        int dist[][]=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[0][0]=0;
        while(!pq.isEmpty()){
            int effort=pq.peek()[0];
            int row=pq.peek()[1];
            int col=pq.peek()[2];
            pq.poll();
            for(int i=0;i<4;i++){
                int newrow=row+rowArr[i];
                int newcol=col+colArr[i];
                if(newrow>=0 && newcol>=0 && newrow<n && newcol<m){
                    if(dist[newrow][newcol]>Math.max(effort,Math.abs(grid[newrow][newcol]-grid[row][col]))){
                        dist[newrow][newcol]=Math.max(effort,Math.abs(grid[newrow][newcol]-grid[row][col]));
                        pq.add(new int[]{dist[newrow][newcol],newrow,newcol});
                    }
                }
            }
        }
        return dist[n-1][m-1];
    }
}