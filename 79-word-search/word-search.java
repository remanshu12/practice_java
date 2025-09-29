class Solution {
    static int index=0;
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        boolean visited[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                visited[i][j]=false;
            }
        }
        int arr[]=new int[1];
        arr[0]=0;
         int delrow[]={-1,0,1,0};
        int delcol[]=  {0,1,0,-1};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(arr[0])){
                    if(dfs(i,j,board,visited,word,n,m,delrow,delcol,arr)==true){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    static boolean dfs(int row,int col,char[][] board,boolean[][] vis,String word,int n,int m,int[] delrow,int[] delcol,int arr[]){
       
        if(word.length()-1==arr[0]){
            return true;
        } vis[row][col]=true;
        arr[0]++;
        for(int i=0;i<4;i++){
            int newrow=row+delrow[i];
            int newcol=col+delcol[i];
            if(newrow>=0 && newcol>=0 && newcol<m && newrow<n && vis[newrow][newcol]==false && board[newrow][newcol]==word.charAt(arr[0])){
                if(dfs(newrow,newcol,board,vis,word,n,m,delrow,delcol,arr)==true){
                    return true;
                }
            }
        }
        vis[row][col]=false;
        arr[0]--;
        return false;

    }
}