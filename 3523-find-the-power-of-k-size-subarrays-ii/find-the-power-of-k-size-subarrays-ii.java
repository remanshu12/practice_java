class Solution {
    public int[] resultsArray(int[] nums, int k) {
         int n=nums.length;
        int last=nums[0]-1;
        int count=0;
         int[] arr=new int[1+n-k];
        for(int i=0;i<n;++i){
             int num=nums[i];
            if(num==(last+1)){
                count++;
            } else {
                count=1;
            }
            last=num;
             int q=1+i-k;
            if (q >=0){
                arr[q]=(count>=k?last:-1);
            }
        }
        return arr;
    }

}