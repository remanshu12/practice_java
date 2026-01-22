class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
       int and=arr2[0];
        for(int i=1;i<arr2.length;i++){
          and^=arr2[i];
        }
        
        int res=arr1[0]&and;
        for(int i=1;i<arr1.length;i++){
            res^=(arr1[i]&and);
           
        }
        return res;


    }
}