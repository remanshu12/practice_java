class Solution {
    public int longestOnes(int[] nums, int k) {
        int arr[]=new int[2];
        int max=0;
        int len=0;
        int i=0;
        for(int j=0;j<nums.length;j++){
            arr[nums[j]]++;
            max=Math.max(arr[1],max);
            if( (j-i+1)-max > k){
                arr[nums[i]]--;
                i++;

            }
            len=Math.max(j-i+1,len);
        }
        return len;
    }
}