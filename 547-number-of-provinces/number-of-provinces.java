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
        int count=0;
        int visited[]=new int[n];
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                dfs(visited,adj,i);
                count++;
            }
        }
        return count;
    }
    static void dfs(int[] visited, ArrayList<ArrayList<Integer>> adj,int curr){
        visited[curr]=1;
        for(int nei:adj.get(curr)){
            if(visited[nei]==0){
            dfs(visited,adj,nei);}
        }
    }
}