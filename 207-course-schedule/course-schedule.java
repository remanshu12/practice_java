class Solution {
    public boolean canFinish(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int ed[]:edges){
            list.get(ed[0]).add(ed[1]);
        }
        Queue<Integer> q=new LinkedList<>();
        int visited[]=new int[n];
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                if(dfs(visited,i,list)==false){
                    return false;
                }
            }
        }
        return true;
        
    }
    static boolean dfs(int[] visited,int node,ArrayList<ArrayList<Integer>> list){
        visited[node]=1;
        for(int nd:list.get(node)){
            if(visited[nd]==0){
                if(!dfs(visited,nd,list)){
                    return false;
                }
            }else if(visited[nd]==1){
                return false;
            }
        }
        visited[node]=2;
        return true;
    }
}