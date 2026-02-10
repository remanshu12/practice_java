class Solution {
public:
    bool dfs(int start,vector<int> color,queue<int> q,vector<vector<int>>& graph){
       
       q.push(start);
       color[start]=1;
       while(!q.empty()){
        int x=q.front();
        q.pop();
        for(auto& p:graph[x]){
            if(color[p]==-1){
                q.push(p);
                color[p]=!color[x];
            }else if(color[p]==color[x]){
                return false;
            }
        }

       }
       return true;
    }
    bool isBipartite(vector<vector<int>>& graph) {
        int n=graph.size();
       vector<int> color(n,-1);
       queue<int> q;
       for(int i=0;i<n;i++){
        if(color[i]==-1){
            if(dfs(i,color,q,graph)==false){
                return false;
            }
        }
       }
       return true;
    }
};