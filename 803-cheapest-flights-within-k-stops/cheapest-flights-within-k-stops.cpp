class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        vector<pair<int,int>> adj[n];
        for(auto it:flights){
            adj[it[0]].push_back({it[1],it[2]});    
        }
        queue<pair<int,pair<int,int>>> q;
        q.push({0,{src,0}});
        vector<int> dist(n,1e9);
        dist[src]=0;
        while(!q.empty()){
           auto front = q.front();
int stops = front.first;
int node  = front.second.first;
int cost  = front.second.second;

            q.pop();
            if(stops>k) continue;
            for(auto iter:adj[node]){
                int adjnode=iter.first;
                int adjdis=iter.second;
                if(cost+adjdis<dist[adjnode] && stops<=k){
                    dist[adjnode]=cost+adjdis;
                    q.push({stops+1,{adjnode,cost+adjdis}});
                }
            }
        }
        if(dist[dst]==1e9) return -1;
        return dist[dst];

    }
};