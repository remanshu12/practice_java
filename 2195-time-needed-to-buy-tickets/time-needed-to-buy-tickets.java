class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
       for(int i=0;i<=k;i++){
        tickets[i]-=1;
       }
       int count=k+1;
       int min=tickets[k];
       for(int i=0;i<tickets.length;i++){
        count+=Math.min(tickets[i],min);
       }
       return count;
    }
}