class Solution {
    public int diagonalSum(int[][] mat) {
        int n=mat.length;
        int m=mat.length;
        int i=0;
        int j=0;
        int sum=0;
        while(i<n && j<m){
            sum+=mat[i][j];
            mat[i][j]=0;
            i++;
            j++;
        }
        i=0;
        j=m-1;
        while(j>=0 && i<n){
            sum+=mat[i][j];
            i++;
            j--;
        }
        return sum;
    }
}