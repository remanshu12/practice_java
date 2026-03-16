class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] grid) {
        List<List<Integer>> list=new ArrayList<>();
        int n=grid.length;
        int m=grid[0].length;
        boolean pac[][]=new boolean[n][m];
        boolean at[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            dfs(i,0,pac,n,m,grid);
            dfs(i,m-1,at,n,m,grid);
        }
        for(int i=0;i<m;i++){
            dfs(0,i,pac,n,m,grid);
            dfs(n-1,i,at,n,m,grid);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(at[i][j]&& pac[i][j]){
                    list.add(Arrays.asList(i,j));
                }
            }
        }
        return list;
    }
    static void dfs(int row,int col,boolean[][] arr,int n,int m,int grid[][]){
        arr[row][col]=true;
        int rowArr[]={-1,1,0,0};
        int colArr[]={0,0,1,-1};
        for(int i=0;i<4;i++){
            int newrow=rowArr[i]+row;
            int newcol=colArr[i]+col;
            if(newrow>=0 && newcol>=0 && newrow<n && newcol<m && grid[row][col]<=grid[newrow][newcol] && arr[newrow][newcol]!=true){
                dfs(newrow,newcol,arr,n,m,grid);
            }
        }
    }
}