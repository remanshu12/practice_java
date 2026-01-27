class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int arr[]=new int[nums.length+1];
        for(int i=0;i<queries.length;i++){
            int a=queries[i][0];
            int b=queries[i][1];
            arr[a]+=1;
            arr[b+1]+=-1;
        }
        for(int i=1;i<=nums.length;i++){
            arr[i]=arr[i]+arr[i-1];
        }
        for(int i=0;i<nums.length;i++){
            if(arr[i]<nums[i]){
                return false;
            }
        }
        return true;
    }
}