class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<List<int[]>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int ar[]:edges){
            int u=ar[0];
            int v=ar[1];
            int w=ar[2];
            list.get(u).add(new int[]{v,w});
            list.get(v).add(new int[]{u,w});
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        pq.add(new int[]{0,0});
        dist[0]=0;
        while(!pq.isEmpty()){
            int time=pq.peek()[0];
            int node=pq.peek()[1];
            pq.poll();
            if(time>dist[node]){
                continue;
            }if(time>disappear[node]){
                continue;
            }
            for(int[] ed:list.get(node)){
                int no=ed[0];
                int wt=ed[1];
                if(wt+time<dist[no] && wt+time< disappear[no]){
                    dist[no]=wt+time;
                    pq.add(new int[]{wt+time,no});
                }
            }
        }
        for(int i=0;i<n;i++){
            if(dist[i]==Integer.MAX_VALUE){
                dist[i]=-1;
            }
        }
        return dist;
        
    }
}