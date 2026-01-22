class Solution {
    private int maxi=1000000007;
    public int monkeyMove(int n) {
        return (int)(((maxi+solve(n))-2)% maxi);
    }
    private long solve(int n){
        if(n==1)return 2;
        if(n%2==0){
            long half=solve(n/2);
            return(half*half)%maxi;
        }else{
            long half=solve(n/2);
            return ((half*half)%maxi)*2%maxi; 
        }
    }
}