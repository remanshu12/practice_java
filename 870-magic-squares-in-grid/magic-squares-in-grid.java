class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count=0;
        for(int i=0;i<=grid.length-3;i++){
            for(int j=0;j<=grid[0].length-3;j++){
                if(isMagic(i,j,grid)){
                    count++;
                }
            }
        }
        return count;
    }

    static boolean isMagic(int r,int c,int[][] g){
        boolean[] seen=new boolean[10];
        for(int i=r;i<r+3;i++){
            for(int j=c;j<c+3;j++){
                int v=g[i][j];
                if(v<1||v>9||seen[v]) return false;
                seen[v]=true;
            }
        }

        if(g[r+1][c+1]!=5) return false;

        for(int i=0;i<3;i++){
            if(g[r+i][c]+g[r+i][c+1]+g[r+i][c+2]!=15) return false;
            if(g[r][c+i]+g[r+1][c+i]+g[r+2][c+i]!=15) return false;
        }

        if(g[r][c]+g[r+1][c+1]+g[r+2][c+2]!=15) return false;
        if(g[r][c+2]+g[r+1][c+1]+g[r+2][c]!=15) return false;

        return true;
    }
}
