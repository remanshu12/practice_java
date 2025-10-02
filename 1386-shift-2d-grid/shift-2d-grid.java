class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        int y=0;
        int arr[]=new int[n*m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[y++]=grid[i][j];
            }
        }
        int size=n*m;
         k=k%(m*n);
         int w=0;
        int dupli[]=new int[k];
        for(int i=size-k;i<size;i++){
            dupli[w++]=arr[i];
        }
        int z=size-1;
        for(int i=size-k-1;i>=0;i--){
            arr[z--]=arr[i];
        }
        for(int i=0;i<k;i++){
            arr[i]=dupli[i];
        }
        List<List<Integer>> ans=new ArrayList<>();
        int index=0;
        for(int i=0;i<n;i++){
            List<Integer> row=new ArrayList<>();
            for(int j=0;j<m;j++){
                row.add(arr[index++]);
            }ans.add(row);
        }
        return ans;

    }
}