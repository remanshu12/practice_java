class Solution {
    public int eraseOverlapIntervals(int[][] arr) {
        Arrays.sort(arr,(a,b)->a[1]-b[1]);
        int start=arr[0][0];
        int end=arr[0][1];
        int count=0;
        for(int i=1;i<arr.length;i++){
            if(end<=arr[i][0]){
                start=arr[i][0];
                end=arr[i][1];
            }else{
                count++;
            }
        }
        return count;
    }
}