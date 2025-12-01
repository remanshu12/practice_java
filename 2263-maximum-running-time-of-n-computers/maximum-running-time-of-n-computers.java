class Solution {
    public long maxRunTime(int n, int[] arr) {
     long low=0;
     long sum=0;
     for(int i:arr){
        sum+=i;
     }
     long high=sum/n;
     long ans=-1;
     while(low<=high){
        long mid=low+(high-low)/2;
        if(ispossible(mid,arr,n)){
            ans=mid;
            low=mid+1;
        }else{
            high=mid-1;
        }
     }
     return ans;
     
     }
     static boolean ispossible(long mid,int arr[],int n){
        long val=0;
        for(int i:arr){
            val+=Math.min(i,mid);
        }
        return val>=mid*n;
    }
}