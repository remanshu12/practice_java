class Solution {
    public int maxRemoval(int[] nums, int[][] que) {
        int q=que.length;
        int n=nums.length;
        PriorityQueue<Integer> maxheap=new PriorityQueue<>((a,b)->b-a);
        PriorityQueue<Integer> past=new PriorityQueue<>();
        Arrays.sort(que,(a,b)->a[0]-b[0]);
        int j=0;
        int used=0;
        for(int i=0;i<n;i++){
            while(j<q && que[j][0]==i){
                maxheap.add(que[j][1]);
              //  System.out.println(que[j][1]);
                j++;
            }
            nums[i]-=past.size();
            while(!maxheap.isEmpty() && nums[i]>0 && maxheap.peek()>=i){
                int ending=maxheap.poll();
                nums[i]-=1;
                past.add(ending);
              //  System.out.println("he;;");
                used++;
            }
            if(nums[i]>0){
                return -1;
            }
            while(!past.isEmpty() && past.peek()<=i){
                past.poll();
            }
        }
        return q-used;
    }
}