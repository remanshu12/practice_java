class Solution {
    long mod=1_000_000_007;
    public int numWays(String s) {
        long one=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                one++;
            }
        }
        long n=s.length();
        if(one==0){
            return (int)(((n-1)*(n-2)/2)%mod);
        }
        if(one%3!=0){
            return 0;
        }
        long val=one/3;
        long zero1=0;
        long zero2=0;
        //long total=1;
        one=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                one++;}
                if(one==val){
                    zero1++;
                }
                if(one==2*val){
                    zero2++;
                }
            
        }
       
        return (int)((zero1*zero2)%mod);
    }
}