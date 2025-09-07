class Solution {  
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
       List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return res;

       
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[0]-b[0]); 
        for(int i=0;i<Math.min(k,nums1.length);i++){
             pq.add(new int[]{nums1[i]+nums2[0],i,0});
        } 

        while(!pq.isEmpty() && res.size()<k){
             int[] top = pq.poll();
              int i = top[1];
            int j = top[2];
            res.add(Arrays.asList(nums1[i], nums2[j]));
            if(j+1<nums2.length){
                pq.add(new int[]{nums1[i]+nums2[j+1],i,j+1});
            }
        }
        return res;
    }
}