class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n=prices.length;
        long base_profit=0;
        for (int i=0;i<n;i++) {
            base_profit+=strategy[i]*prices[i];
        }
        long[] prefix_sum_prices=new long[n + 1];
        long[] prefix_sum_strategy=new long[n + 1];
        for(int i=0;i<n;i++) {
            prefix_sum_prices[i+1]=prefix_sum_prices[i]+prices[i];
            prefix_sum_strategy[i+1]=prefix_sum_strategy[i]+strategy[i]*prices[i];
        }
        long max_gain=0;
        int half=k/2;
        for (int i=0;i+k<=n;i++) {
            long old_segment=prefix_sum_strategy[i+k]-prefix_sum_strategy[i];
            long new_segment=prefix_sum_prices[i+k]-prefix_sum_prices[i+half];
            long gain=new_segment-old_segment;
            max_gain=Math.max(max_gain, gain);
        }
        return base_profit+Math.max(0,max_gain);
    }
}