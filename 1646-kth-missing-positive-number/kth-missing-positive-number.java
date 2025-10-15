class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low=0;
        int high=arr.length-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int mising=arr[mid]-mid-1;
            if(mising<k){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
//         [2,3,4,7,11]
// mising=  1 1 1 3  6
//               ans 
//               7+2=9//anss
//         // arr[ans]+more need(k-mising)
//         //arr[ans]+k-(arr[ans]-(ans+1))

        return ans+k+1;
    }
}