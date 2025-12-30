class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int n=isConnected.length;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adj.get(i).add(j);

                }
            }
        }
        int visited[]=new int[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                count++;
                dfs(visited,adj,i);
            }
        }
        

        return count;
    }
    static void dfs(int[] visited,ArrayList<ArrayList<Integer>> adj,int curr){
        visited[curr]=1;
        for(int neigh:adj.get(curr)){
            if(visited[neigh]==0){
                dfs(visited,adj,neigh);
            }
        }
    }
}