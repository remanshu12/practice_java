class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod=1_000_000_007;
        List<List<int[]>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            int u=roads[i][0];
            int v=roads[i][1];
            int w=roads[i][2];
            list.get(u).add(new int[]{v,w});
            list.get(v).add(new int[]{u,w});
        }
        long dist[]=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0]=0;
        int ways[]=new int[n];
        ways[0]=1;
        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));
        pq.add(new long[]{0,0});
        while(!pq.isEmpty()){
            long d=pq.peek()[0];
            int u=(int)pq.peek()[1];
            pq.poll();
            if(d>dist[u]) continue;
            for(int[] edge:list.get(u)){
                int v=edge[0];
                long w=edge[1];
                if(dist[v]>dist[u]+w){
                    dist[v]=dist[u]+w;
                    ways[v]=ways[u];
                    pq.add(new long[]{dist[v],v});
                }else if(dist[u]+w==dist[v]){
                   ways[v]=(ways[v]+ways[u])%mod;
                }
            }
        }
        return ways[n-1];
    }
}