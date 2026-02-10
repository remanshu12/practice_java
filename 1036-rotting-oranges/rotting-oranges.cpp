class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        queue<pair<int,int>> q;
        int n= grid.size();
        int m=grid[0].size();
        int fresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    fresh++;
                }else if(grid[i][j]==2){
                    q.push({i,j});
                }
            }
        }
        if(fresh==0) return 0;
        int time=0;
        int dx[]={-1,0,1,0};
        int dy[]={0,1,0,-1};
        while(!q.empty()){
            int size=q.size();
            bool rotton=false;
            for(int i=0;i<size;i++){
                auto [x,y]=q.front();
                q.pop();
                for(int j=0;j<4;j++){
                    int newr=x+dx[j];
                    int newc=y+dy[j];
                    if(newr>=0 && newr<n && newc>=0 && newc<m && grid[newr][newc]==1){
                        grid[newr][newc]=2;
                        q.push({newr,newc});
                        fresh--;
                        rotton=true;
                    }
                }
            }
            if(rotton==true){
                time++;
            }
        }
        if(fresh==0) return time;
        return -1;
    }
};