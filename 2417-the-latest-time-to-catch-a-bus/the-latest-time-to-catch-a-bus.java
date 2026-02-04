class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int i=0;
        int j=0;
        int n=buses.length;
        int m=passengers.length;
            int curr=0;

        for( i=0;i<n;i++){
            curr=0;
            while(j<m && curr<capacity && passengers[j]<=buses[i]){
                curr++;
                j++;
            }
        }
        int time=0;
        if(curr==capacity){
            time=passengers[j-1];
        }else{
            time=buses[n-1];
        }
        j--;
        while(j>=0 && passengers[j]==time){
            j--;
            time--;
        }
        return time;

    }
}