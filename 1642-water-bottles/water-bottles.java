class Solution {
    public int numWaterBottles(int full, int ex) {
        int total=full;
        int rem=0;
        int div=0;
        while(full>=ex){
            div=full/ex;
            rem=full%ex;
            total+=div;
            full=div+rem;
        }
        return total;
    }
}