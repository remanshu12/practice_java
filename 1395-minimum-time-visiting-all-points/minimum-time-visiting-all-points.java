class Solution {
    public int minTimeToVisitAllPoints(int[][] arr) {
        int ans=0;
        for(int i=1;i<arr.length;i++){
            int x=arr[i][0];
            int y=arr[i][1];
            int a=arr[i-1][0];
            int b=arr[i-1][1];
        ans+=Math.max(Math.abs(x-a),Math.abs(y-b));
        }
        return ans;
    }
}