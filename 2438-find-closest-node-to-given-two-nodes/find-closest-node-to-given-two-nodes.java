class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n=edges.length;
        int dist1[]=new int[n];
        int dist2[]=new int[n];
        for(int i=0;i<n;i++){
            dist1[i]=(int)1e9;
            dist2[i]=(int)1e9;
        }
        boolean visited1[]=new boolean[n];
        boolean visited2[]=new boolean[n];
        dist1[node1]=0;
        dist2[node2]=0;
        dfs(edges,visited1,dist1,node1);
        dfs(edges,visited2,dist2,node2);
        int min=Integer.MAX_VALUE;
        int minInd=-1;

        for(int i=0;i<n;i++){
            int max=Math.max(dist1[i],dist2[i]);
            if(max<min){
                min=max;
                minInd=i;
            }
        }
        if(min==(int)1e9){
            return -1;
        }
        return minInd;
    }
    static void dfs(int[] edges,boolean[] visited,int[] dist,int node){
        visited[node]=true;
        int v=edges[node];
        if(v!=-1 && !visited[v]){
        dist[v]=dist[node]+1;
        dfs(edges,visited,dist,v);}
    }
}