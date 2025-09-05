class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
         PriorityQueue<int[]> minheap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
           int max = Integer.MIN_VALUE;
           for(int i=0;i<nums.size();i++){
            int val=nums.get(i).get(0);
            minheap.add(new int[]{val,i,0});
            max=Math.max(max,val);
           }
           int rangeStart = 0, rangeEnd = Integer.MAX_VALUE;
        while(minheap.size()==nums.size()){
            int[] curr=minheap.poll();
            int minval=curr[0];
            int row=curr[1];
            int col=curr[2];
        
        if(max-minval < rangeEnd-rangeStart){
            rangeEnd=max;
            rangeStart=minval;
        }
        if(col+1 < nums.get(row).size()){
            int nextval=nums.get(row).get(col+1);
                minheap.add(new int[]{nextval,row,col+1});
                max=Math.max(max,nextval);
        }
    }
    return new int[]{rangeStart,rangeEnd};
    }
}