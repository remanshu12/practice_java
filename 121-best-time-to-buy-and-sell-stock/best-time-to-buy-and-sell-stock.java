class Solution {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE;
        int diff=0;
        int ans=0;
        for(int i=0;i<prices.length;i++){
            if(min>prices[i]){
                min=prices[i]; 
            }
            diff=prices[i]-min;
            ans=Math.max(ans,diff);
        }
        return ans;
    }}