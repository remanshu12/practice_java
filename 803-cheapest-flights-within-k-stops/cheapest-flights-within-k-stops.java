class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
          ArrayList<ArrayList<int[]>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int t[]:flights){
            list.get(t[0]).add(new int[]{t[1],t[2]});
        }
        int dist[]=new int[n+1];
        Arrays.fill(dist,(int)1e9);
        dist[src]=0;
         Queue<int[]> q=new LinkedList<>();
         q.add(new int[]{0,src,0});
          while(!q.isEmpty()){
        int dis=q.peek()[0];
        int node=q.peek()[1];
        int stops=q.peek()[2];
         q.poll();
        if(stops>k) continue;
       
        for(int pair[]:list.get(node)){
                int nd=pair[0];
                int duri=pair[1];
                if(dist[nd]>dis+duri){
                    dist[nd]=dis+duri;
                    q.add(new int[]{dis+duri,nd,stops+1});
                }
        }
    }
   
    return dist[dst]==(int)1e9?-1:dist[dst];
    }
}