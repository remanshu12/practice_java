class Solution {
    public int minNonZeroProduct(int p) {
        if(p==1){
            return 1;
        }
        long mod=1_000_000_007;
        //       2^4 -1
        long max=(1L<<p)-1;
          //        base 14
        long base=max-1;
        long pair=base/2;
        long res=pow(base,pair,mod);
        return (int)((res*(max%mod))%mod);
        
    }
    static long pow(long base,long power,long mod){
    long ans=1;
    base%=mod;
    while(power>0){
        if(power%2==1){
            ans=(ans*base)%mod;
        }
        base=(base*base)%mod;
        power/=2;
    }
    return ans;}
}