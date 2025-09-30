class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q=new ArrayDeque<>();
           int n=nums.length;
    int arr[]=new int[n-k+1];
 int y=0;
    for(int i=0;i<n;i++){
        if(!q.isEmpty() && q.getFirst()<=(i-k)){
            q.removeFirst();
        }
        while(!q.isEmpty() && nums[q.getLast()]<=nums[i]){
            q.removeLast();
        }
        q.addLast(i);
        if(i>=k-1){
            arr[y++]=nums[q.getFirst()];
        }
    }
    return arr;
    }
}