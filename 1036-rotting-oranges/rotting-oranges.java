class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0){
            return -1;
        } 
        int n=grid.length;
        int m=grid[0].length;
        int fresh=0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j,0});
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0){
            return 0;
        }
        int time=0;
        int delrow[]={-1,0,+1,0};
        int delcol[]={0,+1,0,-1};
        while(!q.isEmpty()){
            int row=q.peek()[0];
            int col=q.peek()[1];
            int val=q.peek()[2];
            q.poll();
            time=Math.max(time,val);
            for(int i=0;i<4;i++){
                int newrow=row+delrow[i];
                int newcol=col+delcol[i];
                if(newrow>=0 && newrow<n && newcol>=0 && newcol<m && grid[newrow][newcol]==1){
                    grid[newrow][newcol]=2;
                    fresh--;
                    q.add(new int[]{newrow,newcol,time+1});
                }
            }
        }
        return fresh==0 ? time:-1;
    }
}