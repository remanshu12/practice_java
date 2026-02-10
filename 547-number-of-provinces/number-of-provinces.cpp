class Solution {
public:
    void dfs(int curr,vector<int>& visited,vector<vector<int>>& adj){
        visited[curr]=1;
        for(int nei:adj[curr]){
            if(visited[nei]==0){
                dfs(nei,visited,adj);
            }
        }
    }
    int findCircleNum(vector<vector<int>>& isConnected) {
        int n=isConnected.size();
        vector<vector<int>> adj(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adj[i].push_back(j);
                }
            }
        }
        int count=0;
        vector<int> visited(n,0);
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                count++;
                dfs(i,visited,adj);
                
            }
        }
        return count;
    }
};