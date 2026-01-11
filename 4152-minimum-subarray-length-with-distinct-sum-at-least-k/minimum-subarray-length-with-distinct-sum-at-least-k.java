class Solution {
    public int minLength(int[] nums, int k) {
        int minlen=Integer.MAX_VALUE;
        int arr[]=new int[100001];
        int currsum=0;
        int left=0;
        for(int i=0;i<nums.length;i++){
            int val=nums[i];
            if(arr[val]==0){
                currsum+=val;
            }
            arr[val]++;
            while(currsum>=k){
                minlen=Math.min(minlen,i-left+1);
                int w=nums[left];
                arr[w]--;
                if(arr[w]==0){
                    currsum-=w;
                }
                left++;
            }
         }
         return minlen==Integer.MAX_VALUE?-1:minlen;
    }
}