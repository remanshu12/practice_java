class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq=new PriorityQueue<>();
        Set<Long> set=new HashSet();
        set.add(1L);
        pq.add(1L);
        long ugly=1;
        for(int i=0;i<n;i++){
            ugly=pq.poll();
            if(set.add(ugly*2)){
                pq.add(ugly*2);
            }
             if(set.add(ugly*3)){
                pq.add(ugly*3);
            }
             if(set.add(ugly*5)){
                pq.add(ugly*5);
            }

        }
        return (int)ugly;
    }
}