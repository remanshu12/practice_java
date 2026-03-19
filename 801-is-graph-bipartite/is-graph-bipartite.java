class Solution {
    public boolean isBipartite(int[][] graph) {
       int n=graph.length;
        int visited[]=new int[n];
        Arrays.fill(visited,-1);
        for(int i=0;i<n;i++){
            if(visited[i]==-1){
                visited[i]=0;
                if(!dfs(i,visited,graph)){
                    return false;
                }
            }
        }
        return true;
    }
    static boolean dfs(int node,int visited[],int[][] graph){
        for(int nd:graph[node]){
            if(visited[nd]==-1){
                if(visited[node]==1){
                    visited[nd]=0;
                }else{
                    visited[nd]=1;
                }
                if(!dfs(nd,visited,graph)){
                    return false;
                }
            }else{
                if(visited[nd]==visited[node]){
                    return false;
                }
            }
        }
        return true;
    }
}