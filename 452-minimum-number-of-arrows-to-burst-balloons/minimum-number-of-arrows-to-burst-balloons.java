class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
       
        int end=points[0][1];
        int count=1;
        for(int i=1;i<points.length;i++){
         int min=points[i][0];
            int max=points[i][1];
            if(end<min){
                count++;
                end=max;
            }
        }
        return count;
    }
}