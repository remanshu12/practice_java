class Solution {
    public void rotate(int[][] arr) {
        int row=arr[0].length;
        int col=arr.length;
        for(int i=0;i<row;i++){
            for(int j=i+1;j<col;j++){
                
                    int temp=arr[i][j];
                    arr[i][j]=arr[j][i];
                    arr[j][i]=temp;
                
            }
        }
        
        for(int i=0;i<row;i++){
            int l=0;
        int r=col-1;
            while(l<r){
            int temp=arr[i][r];
            arr[i][r]=arr[i][l];
            arr[i][l]=temp;
            l++;
            r--;
        }}
    }
}