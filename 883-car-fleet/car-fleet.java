class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n=position.length;
        double cars[][]=new double[n][2];
        for(int i=0;i<n;i++){
            cars[i][0]=position[i];
            cars[i][1]=(double)(target-position[i])/speed[i];
        }
        Arrays.sort(cars,(a,b)->Double.compare(b[0],a[0]));
        int fleet=0;
        double last=0.0;
        for(int i=0;i<n;i++){
            double current=cars[i][1];
            if(current>last){
                fleet++;
                last=current;
            }
        }
        return fleet;

        }
}