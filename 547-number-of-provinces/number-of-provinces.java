class Solution {
    public int findCircleNum(int[][] arr) {
        int n=arr.length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<arr[0].length;j++){
                if(i!=j && arr[i][j]==1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int count=0;
        int visited[]=new int[n];
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                count++;
                 dfs(i,adj,visited);  
            }
        }
        return count;
    }
    static void dfs(int node,ArrayList<ArrayList<Integer>> adj,int visited[]){
        visited[node]=1;
        for(int n:adj.get(node)){
            if(visited[n]==0){
                dfs(n,adj,visited);
            }
        }
    }
}