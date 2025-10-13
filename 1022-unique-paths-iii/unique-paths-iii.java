class Solution {
    int result=0;
    public int uniquePathsIII(int[][] grid) {
        int nonobstacle=0;
        int x=0;
        int y=0;
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    nonobstacle++;
                }
                if(grid[i][j]==1){
                    x=i;
                    y=j;
                }
            }
        }
        nonobstacle++;
        backtrack(grid,0,x,y,m,n,nonobstacle);
        return result;
    }
     void backtrack(int grid[][],int count,int x,int y,int m,int n,int nonobstacle){
        if(x<0 || y<0 || x>=m || y>=n || grid[x][y]==-1){
            return ;
        }
        if(grid[x][y]==2){
            if(count==nonobstacle){
                result++;
               
            }
            return;
        }
        grid[x][y]=-1;
        backtrack(grid,count+1,x-1,y,m,n,nonobstacle);
        backtrack(grid,count+1,x,y+1,m,n,nonobstacle);
        backtrack(grid,count+1,x+1,y,m,n,nonobstacle);
        backtrack(grid,count+1,x,y-1,m,n,nonobstacle);

        grid[x][y]=0;
    }
}