class Solution {
    public int longestOnes(int[] arr, int k) {
          int start=0;
        int end=0;
       int temp=k;
        int max=0;
        int count=0;
        while(end<arr.length){
           
            
            if(arr[end]==1){
                end++;
                count++;
            }else if(arr[end]==0 && k>0){
                end++;
                k--;
                count++;
            }
            else if(arr[end]==0 && k==0){
                while(arr[start]!=0){
                    start++;
                    count--;
                }
                start++;
                 count--;
                k++;
               
                
            }
            max=Math.max(count,max);
           // System.out.println(count);
        
           
        }
      
        return max;
    }
}