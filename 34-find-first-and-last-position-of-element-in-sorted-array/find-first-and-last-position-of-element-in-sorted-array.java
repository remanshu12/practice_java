class Solution {
    public int[] searchRange(int[] nums, int target) {
        int arr[]=new int[2];
        arr[0]=-1;
        arr[1]=-1;
        arr[0]=first(nums,target);
        arr[1]=last(nums,target);
        return arr;
    }
    static int first(int arr[],int target){
        int low=0;
        int ans=-1;
        int high=arr.length-1;
         while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target){
               high=mid-1;
               ans=mid;
            }else if(arr[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    static int last(int arr[],int target){
        int low=0;
        int ans=-1;
        int high=arr.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target){
               low=mid+1;
               ans=mid;
            }else if(arr[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}