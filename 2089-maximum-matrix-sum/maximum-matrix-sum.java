class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum=0;
        int neg=0;
        int n=matrix.length;
        int m=matrix[0].length;
        int min=Integer.MAX_VALUE;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]<0){
                    neg++;
                }
                sum+=(Math.abs(matrix[i][j]));
                min=Math.min(min,Math.abs(matrix[i][j]));

            }
        }
        if(neg%2==0){
            return sum;
        }
        return sum-2*min;


    }
}