class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        if(source==destination || n==1|| edges.length==0){
            return true;
        }
        for(int ar[]:edges){
            adj.get(ar[0]).add(ar[1]);
            adj.get(ar[1]).add(ar[0]);
        }
        System.out.println(adj);
        int visited[]=new int[n];
        return dfs(adj,edges,source,destination,visited);
    }
    static boolean dfs(List<List<Integer>> adj,int[][] edges,int s,int e,int[] visited){
        if(s==e){
            return true;
        }
        visited[s]=1;
        for(int ed:adj.get(s)){
            if(visited[ed]!=1){
                if(dfs(adj,edges,ed,e,visited)){
                    return true;
                }
            }
        }
        return false;
    }
}