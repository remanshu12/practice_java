class Solution {
    public int maxDistance(int[] arr, int m) {
        Arrays.sort(arr);
        int low=1;
        int ans=-1;
        int high=arr[arr.length-1]-arr[0];
        while(low<=high){
            int mid=low+(high-low)/2;
            if(check(mid,arr,m)){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }return ans;
    }
    static  boolean check(int mid,int[] arr,int m){
        int i=0;
        int j=1;
        int count=1;
        while(j<arr.length){
            if(arr[j]-arr[i]>=mid){
                
                i=j;
                j++;
                count++;
            }else{
                j++;
            }
            if(count>=m){
                return true;
            }
        }
        if(count<m){
            return false;
        }
        return true;
    }
}