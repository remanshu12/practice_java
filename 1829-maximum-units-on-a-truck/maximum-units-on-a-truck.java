class Solution {
    public int maximumUnits(int[][] arr, int size) {
        Arrays.sort(arr,(a,b)->b[1]-a[1]);
        int total=0;
        for(int i=0;i<arr.length;i++){
            int start=arr[i][0];
            int end=arr[i][1];
            if(size>0){
                total+=((Math.min(size,start))*end);
                size-=start;
            }else{
                break;
            }
        }
        return total;
    }
}