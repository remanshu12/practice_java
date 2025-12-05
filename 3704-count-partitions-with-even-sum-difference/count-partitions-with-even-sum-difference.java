class Solution {
    public int countPartitions(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        int curr=0;
        int count=0;
        for(int i=0;i<n-1;i++){
            curr+=nums[i];
            if((curr-(sum-curr))%2==0){
                count++;
            }
        }
        return count;
    }
}