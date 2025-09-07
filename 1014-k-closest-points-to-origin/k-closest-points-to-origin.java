class Solution {
    class pair{
        int val;
        int index;
        pair(int v,int i){
            val=v;
            index=i;
        }
    }
    public int[][] kClosest(int[][] arr, int k) {
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->b.val-a.val);
         for(int i=0;i<arr.length;i++){
            int x=arr[i][0];
            int y=arr[i][1];
            pq.add(new pair(x*x + y*y,i));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Build result
        int[][] result = new int[k][2];
        int idx = 0;
        while (!pq.isEmpty()) {
            pair curr = pq.poll();
            result[idx++] = arr[curr.index];
        }

        return result;
         }
}