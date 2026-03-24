class Solution {
    public int[][] constructProductMatrix(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int[][] ans= new int[n][m];
        //ans[0][0]=1;
        long product=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               ans[i][j]= (int) (product%12345);
               product=(product*arr[i][j])%12345;
               }
            }
            product=1;
            for(int i=n-1;i>=0;i--){
                for(int j=m-1;j>=0;j--){
                    ans[i][j]=(int) ((product*ans[i][j])%12345);
                    product=(product *arr[i][j])%12345;
                }
            }
        
return ans;
    }
}