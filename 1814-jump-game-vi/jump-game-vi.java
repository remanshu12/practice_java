class Solution {
    public int maxResult(int[] nums, int k) {
        int n=nums.length;
        int dp[]=new int[n];
        dp[0]=nums[0];
       
        int j=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
         pq.add(new int[]{nums[0],0});
        for(int i=1;i<n;i++){
           
            while(pq.peek()[1]<i-k){
               
               // System.out.println(i+" "+ll);
               pq.poll();
            }
            int val=pq.peek()[0];
            dp[i]=nums[i]+val;
            pq.add(new int[]{dp[i],i});
            
        }
    //   System.out.println(Arrays.toString(dp));
        return dp[n-1];
        
    }
}