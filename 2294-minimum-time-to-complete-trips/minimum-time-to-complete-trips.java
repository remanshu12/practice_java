class Solution {
    public long minimumTime(int[] time, int total) {
        long low=0;
        long min=Integer.MAX_VALUE;
        for(int i=0;i<time.length;i++){
            if(time[i]<min){
                min=time[i];
            }
        }
        long high=min*total;
      //  System.out.println(high);
        long ans=high;
        while(low<=high){
            long mid=low+(high-low)/2;
            if(possible(mid,time,total)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    static boolean possible(long mid,int arr[],int total){
        long count=0;
        for(int i=0;i<arr.length;i++){
            count+=(mid/(long)arr[i]);
        }
        if(count>=total){
            return true;
        }else{
            return false;
        }
    }
}