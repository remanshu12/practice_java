class Solution {
    static boolean dfs(int start,int end,ArrayList<ArrayList<Integer>> list,int visited[]){
        visited[start]=1;
        if(start==end){
            return true;
        }
        for(int nd:list.get(start)){
            if(visited[nd]==0){
            if(dfs(nd,end,list,visited)){
                return true;
            }}
        }
        return false;
    }
    public int[] findRedundantConnection(int[][] edges) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        int n=edges.length;
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int visited[]=new int[n+1];
            if(dfs(u,v,list,visited)){
                return new int[]{u,v};
            }
            list.get(u).add(v);
            list.get(v).add(u);

        }
        return new int[]{0};
    }
}