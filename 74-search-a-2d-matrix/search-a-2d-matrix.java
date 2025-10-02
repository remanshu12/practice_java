class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       
        int low=0;
        int high=matrix[0].length-1;
        int i=0;

            while( i<matrix.length && target>matrix[i][high] ){
                i++;
            }
            if(i>=matrix.length){
                return false;
            }
            while(low<=high){
                int mid=low+(high-low)/2;
                if(matrix[i][mid]==target){
                    return true;
                }else if(matrix[i][mid]>target){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
            return false;
        
        }
    }