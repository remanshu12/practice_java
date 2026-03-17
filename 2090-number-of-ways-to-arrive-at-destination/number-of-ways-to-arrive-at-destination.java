class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod =(int)1000000007;
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
        long count[]=new long[n];
        count[0]=1;
        dist[0]=0;
        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));
        pq.add(new long[]{0,0});
        while(!pq.isEmpty()){
            long dis=pq.peek()[0];
            int node=(int)pq.peek()[1];
            pq.poll();
            for(int nd[]:list.get(node)){
                int curr=nd[0];
                int duri=nd[1];
                if(dis+duri<dist[curr]){
                    dist[curr]=dis+duri;
                    count[curr]=count[node]%mod;
                    pq.add(new long[]{dis+duri,curr});
                }else if(dis+duri==dist[curr]){
                    count[curr]=(count[curr]+count[node])%mod;
                }
            }
        }
        return (int)count[n-1]%mod;
    }
}