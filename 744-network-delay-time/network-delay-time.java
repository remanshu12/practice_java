class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> list=new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        for(int t[]:times){
            list.get(t[0]).add(new int[]{t[1],t[2]});
        }
        int dist[]=new int[n+1];
        Arrays.fill(dist,(int)1e9);
    dist[k]=0;
    PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
    pq.add(new int[]{0,k});
    while(!pq.isEmpty()){
        int dis=pq.peek()[0];
        int node=pq.peek()[1];
        pq.poll();
        for(int pair[]:list.get(node)){
                int nd=pair[0];
                int duri=pair[1];
                if(dist[nd]>dis+duri){
                    dist[nd]=dis+duri;
                    pq.add(new int[]{dis+duri,nd});
                }
        }
    }
    System.out.println(Arrays.toString(dist));
    int max=-1;
   for(int i=1;i<=n;i++){
    if( i!=k){
        max=Math.max(max,dist[i]);
    }
   }
   return max==(int)1e9?-1:max;
    }
}