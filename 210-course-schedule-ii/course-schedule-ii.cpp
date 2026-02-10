class Solution {
public:
    bool dfs(int curr,vector<int>& visited,vector<vector<int>>& adj,stack<int>& st){
        visited[curr]=1;
        for(auto it:adj[curr]){
            if(visited[it]==0){
                if(!dfs(it,visited,adj,st)){
                    return false;
                }
            }else if(visited[it]==1){
                return false;
            }
        }
        visited[curr]=2;
        st.push(curr);
        return true;
    }
    vector<int> findOrder(int num, vector<vector<int>>& prerequisites) {
        int n=prerequisites.size();
        vector<vector<int>> adj(num);
        for(int i=0;i<n;i++){
            adj[prerequisites[i][1]].push_back(prerequisites[i][0]);
        }
        
        stack<int> st;
        vector<int> visited(num,0);
        for(int i=0;i<num;i++){
            if(visited[i]==0){
                if(!dfs(i,visited,adj,st)){
                    return {};
                }
            }
        }
        vector<int> ans;
        while(!st.empty()){
            ans.push_back(st.top());
           st.pop();
        }
        return ans;
    }
};