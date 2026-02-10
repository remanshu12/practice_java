class Solution {
public:
    bool dfs(int curr,vector<int>& visited,vector<vector<int>>& adj){
        visited[curr]=1;
        for(int nei:adj[curr]){
            if(visited[nei]==0){
                if(!dfs(nei,visited,adj)){
                    return false;
                }
            }else if(visited[nei]==1){
                return false;
            }
        }
        visited[curr]=2;
        return true;
    }
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        int n=numCourses;
        vector<vector<int>> adj(n);
        for(auto& p:prerequisites){
            adj[p[1]].push_back(p[0]);
        }
        vector<int> visited(n,0);
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                if(!dfs(i,visited,adj)){
                    return false;
                }
            }
        }
        return true;
    }
};