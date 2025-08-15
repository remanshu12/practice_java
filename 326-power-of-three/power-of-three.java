class Solution {
    public boolean isPowerOfThree(int n) {
       if(n==1){
        return true;
       }
       if(n%3!=0){
        return false;
       }if(n==0 || n==2 || n==4 ||n==5){
        return false;
       }else{
        return isPowerOfThree(n/3);
       }
    }
}