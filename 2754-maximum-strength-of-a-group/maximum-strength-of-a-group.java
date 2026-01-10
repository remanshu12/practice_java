class Solution {
    public long maxStrength(int[] nums) {
        Arrays.sort(nums);
        long sum=1;
        int count=0;
        int zero=0;
        int one=0;
        if(nums.length==1){
            return nums[0];
        }
        for(int i:nums){
            if(i>0){
                sum*=i;
                one++;
            }else if(i<0){
                count++;
            }else{
                zero++;
            }
        }
        if(zero==nums.length){
            return 0;
        }
        if(one==0 && count==1 && zero>=1){
            return 0;
        }
      //  System.out.println(Arrays.toString(nums));
        count=count/2;
        count=count*2;
        for(int i=0;i<count;i++){
            sum*=nums[i];
        }
        return sum;
    }
}