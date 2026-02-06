class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int n=buses.length;
        int m=passengers.length;
        int j=0;
        int curr=0;
        for(int i=0;i<n;i++){
            curr=0;
            while(j<m &&curr<capacity && passengers[j]<=buses[i]){
                curr++;
                j++;
            }

        }
        j-=1;
        int time=0;
        if(curr<capacity){
            time= buses[n-1];
        }else{
            time=passengers[j];
        }
        System.out.println(j);
        while(j>=0 && time==passengers[j]){
            j--;
            time--;
        }
        return time;
    }
}