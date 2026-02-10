class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        int n=mat.size();
        int m=mat[0].size();
        queue<pair<int,int>> q;
        vector<vector<int>> dist(n,vector<int>(m,INT_MAX));
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    dist[i][j]=0;
                    q.push({i,j});
                }
            }
        }
        int dx[]={-1,0,1,0};
        int dy[]={0,1,0,-1};
        while(!q.empty()){
            auto[x,y]=q.front();
            q.pop();
            for(int i=0;i<4;i++){
                int newr=x+dx[i];
                int newc=y+dy[i];
                if(newr>=0 && newc>=0 && newr<n && newc<m  ){
                    if(dist[newr][newc]>dist[x][y]+1){
                       dist[newr][newc]=dist[x][y]+1;
                       q.push({newr,newc});
                    }
                }
            }
        }
        return dist;
    }
};