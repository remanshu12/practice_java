class Solution {
    public int maxDistance(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int n=grid.length;
        int count=0;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    q.add(new int[]{i,j,0});
                }else{
                    count++;
                }
            }
        }
        if(count==n*m || count==0){
            return -1;
        }
        int rowArr[]={-1,1,0,0};
        int colArr[]={0,0,-1,1};
        int max=0;
        while(!q.isEmpty()){
            int row=q.peek()[0];
            int col=q.peek()[1];
            int dis=q.peek()[2];
            q.poll();
            max=Math.max(max,dis);
            for(int i=0;i<4;i++){
                int newrow=row+rowArr[i];
                int newcol=col+colArr[i];
                if(newrow>=0 && newcol>=0 && newrow<n && newcol<m && grid[newrow][newcol]==0){
                    grid[newrow][newcol]=1;
                    count--;
                    q.add(new int[]{newrow,newcol,dis+1});
                }
            }

        }
        return max;

    }
}