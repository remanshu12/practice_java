class Solution {
    static final int mod=1_000_000_007;
    public int countTexts(String press) {
        int n=press.length();
        long[] dp=new long[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            char curr=press.charAt(i-1);
            int max=(curr=='7'|| curr=='9')?4:3;
            for(int k=1;k<=max && i-k>=0 ;k++){
                if(press.charAt(i-k)!=curr){
                    break;
                }
                dp[i]=(dp[i]+dp[i-k])%mod;
            }
        }
        return (int)dp[n];
    }
}