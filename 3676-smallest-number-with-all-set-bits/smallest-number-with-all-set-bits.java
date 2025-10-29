class Solution {
    public int smallestNumber(int n) {
        for(int i=0;i<1000;i++){
            if(Math.pow(2,i)>n){
                return (int)Math.pow(2,i)-1;
            }
        }
        return 0;
    }
}