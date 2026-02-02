class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        TreeSet<Integer> curr=new TreeSet<>((a,b)->nums[a]!=nums[b]?nums[a]-nums[b]:a-b);
         TreeSet<Integer> next=new TreeSet<>((a,b)->nums[a]!=nums[b]?nums[a]-nums[b]:a-b);
         long cost=Long.MAX_VALUE;
         int n=nums.length;
         long currsum=0l;
        for(int i=1;i<=dist+1;i++){
            curr.add(i);
            currsum+=nums[i];
        }
        while(curr.size()>k-1){
            int index=curr.pollLast();
            currsum-=nums[index];
            next.add(index);
        }
        cost=currsum;
        for(int i=1;i<n-1-dist;i++){
            int rightindex=i+dist+1;
            int leftindex=i;
            if(curr.contains(leftindex)){
                currsum-=nums[leftindex];
                curr.remove(leftindex);
                currsum+=nums[rightindex];
                curr.add(rightindex);
            }else{
                next.remove(leftindex);
                next.add(rightindex);
            }
            if(next.size()>0){
                int min=next.first();
                int max=curr.last();
                if(nums[min]<nums[max]){
                    currsum-=nums[max];
                    currsum+=nums[min];
                    curr.remove(max);
                    curr.add(min);
                    next.remove(min);
                    next.add(max);
                }
            }
            cost=Math.min(cost,currsum);
        }
        return cost+nums[0];
    }

}