class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int inicolor=image[sr][sc];
        int[][] ans=image;
        int delrow[]={-1,0,+1,0};
        int delcol[]={0,+1,0,-1};
        dfs(sr,sc,ans,image,color,inicolor,delrow,delcol);
        return ans;
    }
    static void dfs(int sr,int sc,int[][] ans,int[][] image,int color,int inicolor,int[] delrow,int[] delcol){
        ans[sr][sc]=color;
        int n=image.length;
        int m=image[0].length;
        for(int i=0;i<4;i++){
            int newrow=sr+delrow[i];
            int newcol=sc+delcol[i];
            if(newrow>=0 && newrow<n && newcol>=0 && newcol<m && image[newrow][newcol]==inicolor && ans[newrow][newcol]!=color){
                dfs(newrow,newcol,ans,image,color,inicolor,delrow,delcol);
            }
        }
    }
}