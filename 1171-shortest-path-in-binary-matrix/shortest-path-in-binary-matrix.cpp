class Solution {
public:
    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
     int n=grid.size();
     int m=grid[0].size();
     if(grid[0][0] ==1 || grid[n-1][m-1]==1){
        return -1;
     }
     priority_queue<tuple<int,int,int>, vector<tuple<int,int,int>>, greater<tuple<int,int,int>>> q;
     int dx[]={1,0,-1,0,1,-1,1,-1};
     int dy[]={0,1,0,-1,1,-1,-1,1};
     q.push({0,0,1});
    
     vector<vector<int>> dist(n,vector<int>(m,INT_MAX));
     dist[0][0]=1;
     while(!q.empty()){
        auto[x,y,cnt]=q.top();
        
        q.pop();
        if(x==n-1 && y==m-1){
            return cnt;
        }
        for(int i=0;i<8;i++){
            int newrow=x+dx[i];
            int newcol=y+dy[i];
            if(newrow>=0 && newcol >=0 && newrow<n && newcol <m && grid[newrow][newcol]==0){
                if(cnt+1<dist[newrow][newcol]){
                    dist[newrow][newcol]=cnt+1;
                    q.push({newrow,newcol,cnt+1});
                }
                    
                    
            }
        }
     }
     return -1;
    }
};