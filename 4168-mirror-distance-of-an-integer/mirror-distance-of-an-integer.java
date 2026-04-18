class Solution {
    public int mirrorDistance(int n) {
        int num=0;
        long temp=(long)n;
        long sum=0;
        while(n>0){
            int rem=n%10;
            sum=sum*10+rem;
            n=n/10;
        }
        
        return (int)Math.abs(sum-temp);
    }
}