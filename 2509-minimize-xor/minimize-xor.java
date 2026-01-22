class Solution {
    public int minimizeXor(int num1, int num2) {
        int k=Integer.bitCount(num2);
        int x=0;
        for(int i=31;i>=0 && k>0;i--){
            if((num1&(1<<i))!=0){
                x|=(1<<i);
                k--;
            }
        }
        for(int i=0;i<=31 && k>0;i++){
            if((x&(1<<i))==0){
                x|=(1<<i);
                k--;
            }
        }
        return x;
    }
}