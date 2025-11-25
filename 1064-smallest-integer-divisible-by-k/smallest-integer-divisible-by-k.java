class Solution {
    public int smallestRepunitDivByK(int k) {
       int num=0;
        int i=0;
       while(i<=k){
        num=num*10+1;
       num=num%k;
        if(num%k==0){
            return i+1;
        }
        i++;
       }
       return -1;
    }
}