class Solution {
    public long maximumScore(int[] nums, String s) {
    PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
      int count=0;
      int idx=-1;
      int max=0;
      long sum=0;
      for(int i=0;i<nums.length;i++){
        if(s.charAt(i)=='0'){
          pq.add(nums[i]);}
          else{
            pq.add(nums[i]);
            sum+=pq.poll();
          }
      }
      
      return sum;
     
    }
}