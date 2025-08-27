class Solution {
    public long pickGifts(int[] arr, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)-> b-a);
        int as=0;
          for (int x : arr) {
            pq.add(x);
        }
        while(k-- >0){
            as=pq.poll();
             pq.add((int) Math.sqrt(as));
        }
        long max=0;
        while (!pq.isEmpty()) {
            max += pq.poll();
        }
        return max;
    }
}