class Solution {
public:
    int countPaths(int n, vector<vector<int>>& roads) {
        
        const int MOD = 1e9 + 7;
        
        vector<long long> dist(n, LLONG_MAX);
        vector<long long> ways(n, 0);
        
        dist[0] = 0;
        ways[0] = 1;
        
        vector<vector<pair<int,int>>> adj(n);
        
        for(auto &it : roads){
            adj[it[0]].push_back({it[1], it[2]});
            adj[it[1]].push_back({it[0], it[2]});
        }
        
        priority_queue<
            pair<long long,int>,
            vector<pair<long long,int>>,
            greater<pair<long long,int>>
        > pq;
        
        pq.push({0,0});
        
        while(!pq.empty()){
            auto [time,node] = pq.top();
            pq.pop();
            
            if(time > dist[node]) continue;
            
            for(auto &it : adj[node]){
                int adjnode = it.first;
                long long adjtime = it.second;
                
                if(time + adjtime < dist[adjnode]){
                    dist[adjnode] = time + adjtime;
                    ways[adjnode] = ways[node];
                    pq.push({dist[adjnode], adjnode});
                }
                else if(time + adjtime == dist[adjnode]){
                    ways[adjnode] = (ways[adjnode] + ways[node]) % MOD;
                }
            }
        }
        
        return ways[n-1] % MOD;
    }
};
