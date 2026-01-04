class Solution {
    public int sumFourDivisors(int[] nums) {
        int total=0;
        for(int i=0;i<nums.length;i++){
            total+=found(nums[i]);
        }
        return total;
    }
    static int found(int val){
        int count=0;
        int sum=0;
        for(int i=2;i*i<=val;i++){
            if(val%i==0){
                sum+=i;
                int ans=val/i;
                count++;
                if(ans!=i){
                    sum+=ans;
                    count++;
                }else{
                    return 0;
                }
               
            }
        }
        if(count==2){
            return 1+sum+val;
        }
        return 0;
    }
}