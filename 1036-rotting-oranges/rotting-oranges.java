class Solution {
    public int orangesRotting(int[][] grid) {
        int total=0;
        Queue<int[]>q=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    total++;
                }else if(grid[i][j]==2){
                    q.add(new int[]{i,j,0});
                }
            }
        }
        int max=0;
      if(total==0) return 0;
         int rowArr[]={-1,1,0,0};
            int colArr[]={0,0,1,-1};
        while(!q.isEmpty()){
            int row=q.peek()[0];
            int col=q.peek()[1];
            int time=q.peek()[2];
           max=Math.max(max,time);
            q.poll();
            for(int i=0;i<4;i++){
                int newrow=row+rowArr[i];
                int newcol=col+colArr[i];
                if(newrow>=0 && newrow<n && newcol>=0 && newcol<m && grid[newrow][newcol]==1){
                    grid[newrow][newcol]=2;
                    total--;
                    q.add(new int[]{newrow,newcol,time+1});
                }
            }
        }
        return total==0?max:-1;
    }
}