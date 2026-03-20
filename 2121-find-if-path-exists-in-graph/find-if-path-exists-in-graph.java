class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
         List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int visited[]=new int[n];

         for(int ar[]:edges){
            adj.get(ar[0]).add(ar[1]);
            adj.get(ar[1]).add(ar[0]);
        }
        return dfs(source,destination,adj,visited);
    }
    static boolean dfs(int start,int end,List<List<Integer>> adj,int visited[]){
        if(start==end) return true;
        visited[start]=1;
        for(int nd:adj.get(start)){
            if(visited[nd]==0){
                if(dfs(nd,end,adj,visited)){
                    return true;
                }
            }
        }
        return false;
    }
}