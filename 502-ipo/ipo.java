class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> cap=new PriorityQueue<>((a,b)->a[0]-b[0]);
         PriorityQueue<Integer> pro=new PriorityQueue<>((a,b)->b-a);
         for(int i=0;i<capital.length;i++){
            cap.add(new int[]{capital[i],profits[i]});
         }
         while(k-- >0){
            while(!cap.isEmpty() && cap.peek()[0]<=w){
                pro.add(cap.poll()[1]);
            }
            if(pro.isEmpty()){
                break;
            }
            w+=pro.poll();
         }
         return w;
    }
}