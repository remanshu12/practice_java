class Solution {
    public int largestPrime(int n) {
        boolean isprime[]=new boolean[n+1];
        Arrays.fill(isprime,true);
        if(n>=0) isprime[0]=false;
        if(n>=1) isprime[1]=false;
        for(int i=2;i*i<=n;i++){
            if(isprime[i]){
                for(int j=i*i;j<=n;j+=i){
                    isprime[j]=false;
                }
            }
        }
        List<Integer> list=new ArrayList<>();
        for(int i=2;i<=n;i++){
            if(isprime[i]){
                list.add(i);
            }
        }
        int ans=0;
        int sum=0;
        for(int i:list){
            sum+=i;
            if(sum>n) break;
            if(isprime[sum]){
                ans=sum;
            }
        }
        return ans;
    }
}