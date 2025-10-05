class Solution {
    public int getMaximumGold(int[][] grid) {
        int max=0;
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0){
                  max= Math.max(max,dfs(grid,n,m,i,j));
                }
            }
        }
        return max;
    }
    static int dfs(int[][] arr,int n,int m,int i,int j){

         if(i<0 || j<0 || i>=n || j>=m || arr[i][j]==0){
            return 0;
        }
        

        int temp=arr[i][j];
        arr[i][j]=0;
        int a=dfs(arr,n,m,i-1,j);
        int b=dfs(arr,n,m,i,j+1);
        int c=dfs(arr,n,m,i+1,j);
        int d=dfs(arr,n,m,i,j-1);
        arr[i][j]=temp;
        return temp + Math.max(Math.max(a, b), Math.max(c, d));
    }
}