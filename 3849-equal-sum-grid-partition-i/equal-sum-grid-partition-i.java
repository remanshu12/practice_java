class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        long total=0;
        long row[]=new long[n];
        long col[]=new long[m];
        for(int i=0;i<n;i++){
            long sum=0;
            for(int j=0;j<m;j++){
                sum+=grid[i][j];
            }
            row[i]=sum;
            total+=sum;
        }
        for(int j=0;j<m;j++){
            long sum=0;
            for(int i=0;i<n;i++){
                sum+=grid[i][j];
            }
            col[j]=sum;
        }
        if(total%2!=0) return false;
        long curr=0;
        for(int i=0;i<n;i++){
            curr+=row[i];
            if(curr==total/2){
                return true;
            }
        }
        curr=0;
        for(int i=0;i<m;i++){
            curr+=col[i];
            if(curr==total/2){
                return true;
            }
        }
        return false;
        

    }
}