class Solution {
    public int findLHS(int[] arr) {
        Arrays.sort(arr);
        int start=0;
        int end=1;
        int max=0;
        while(end<arr.length){
            if((arr[end]-arr[start])==1){
                max=Math.max(max,end-start+1);}
                if((arr[end]-arr[start])<=1){
                    end++;
                }
                else{
                    start++;
                }
            
        }
        return max;
    }
}