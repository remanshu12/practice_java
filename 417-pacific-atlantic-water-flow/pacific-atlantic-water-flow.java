class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] height) {
        int row=height.length;
        int col=height[0].length;
        boolean[][] pacific=new boolean[row][col];
        boolean[][] atlantic=new boolean[row][col];
        for(int i=0;i<row;i++){
            dfs(row,col,i,0,height,pacific);
             dfs(row,col,i,col-1,height,atlantic);

        }
        for(int i=0;i<col;i++){
             dfs(row,col,0,i,height,pacific);
             dfs(row,col,row-1,i,height,atlantic);
        }
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }
    static void dfs(int rows,int cols,int row,int col,int[][] height,boolean[][] visited){
        visited[row][col]=true;
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        for(int i=0;i<4;i++){
            int newrow=row+delrow[i];
            int newcol=col+delcol[i];
            if(newrow>=0 && newcol>=0 && newrow<rows && newcol<cols && visited[newrow][newcol]!=true && height[newrow][newcol]>=height[row][col]){
                dfs(rows,cols,newrow,newcol,height,visited);
            }
        }
    }
}