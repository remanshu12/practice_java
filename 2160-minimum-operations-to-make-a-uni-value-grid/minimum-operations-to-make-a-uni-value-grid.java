class Solution {
    public int minOperations(int[][] grid, int x) {
    int n=grid.length;
    int m=grid[0].length;
    if(n*m==1) return 0;
    int arr[]=new int[n*m];
    int ind=0;
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            arr[ind++]=grid[i][j];
        }   
    }
    Arrays.sort(arr);
    int mid=(n*m)/2;
    int val=arr[mid];
    int count=0;
    for(int i=0;i<n*m;i++){
        if(arr[i]%x!=arr[0]%x){
            return -1;
        }
        count+=(Math.abs(val-arr[i]))/x;


    }
    return count;
    }
}