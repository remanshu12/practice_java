class Solution {
    public int maxArea(int[] arr) {
       int l=0;
       int max=0;
       int r=arr.length-1;
       while(l<r){
        int c=Math.min(arr[l],arr[r]);
    max=Math.max(max,(r-l)*c);
    if (arr[l] > arr[r]) { r--; } else { l++; }
       }
       return max;
    }
    
}