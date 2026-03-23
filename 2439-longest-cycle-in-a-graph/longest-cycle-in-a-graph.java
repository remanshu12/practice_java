class Solution {
    static int max=0;
    public int longestCycle(int[] edges) {
        max=-1;
        int n=edges.length;
         int visited[]=new int[n];
        int count[]=new int[n];
        Arrays.fill(count,1);
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                dfs(visited,i,count,edges);
            }
        }
        return max;
    }
    static void dfs(int[] visited,int node,int[] count,int edges[]){
        visited[node]=1;

      int nd=edges[node];
      if(nd!=-1){
            if(visited[nd]==0){
                count[nd]=count[node]+1;
                dfs(visited,nd,count,edges);
            }else if(visited[nd]==1){
                max=Math.max(max,count[node]-count[nd]+1);
            }
      }
        visited[node]=2;
        
    }
}