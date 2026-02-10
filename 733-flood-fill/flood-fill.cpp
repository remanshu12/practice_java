class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        int n=image.size();
        int m=image[0].size();
        queue<pair<int,int>> q;
        q.push({sr,sc});
       
        int dx[]={-1,0,1,0};
        int dy[]={0,1,0,-1};
        int temp=image[sr][sc];
        while(!q.empty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                auto[x,y]=q.front();
                q.pop();
                for(int j=0;j<4;j++){
                    int newr=x+dx[j];
                    int newc=y+dy[j];
                    if(newr>=0 && newc>=0 && newr<n && newc <m && image[newr][newc]==temp){
                        image[newr][newc]=-1;
                        q.push({newr,newc});
                    }
                }

            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(image[i][j]==-1){
                    image[i][j]=color;
                }
            }
        }
         image[sr][sc]=color;
        return image;

    }
};