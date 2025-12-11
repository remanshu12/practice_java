class Solution {
public:
    int countCoveredBuildings(int n, vector<vector<int>>& arr) {
        vector<int> minXforY(n+1,-1);
        vector<int> maxXforY(n+1,-1);
        vector<int> minYforX(n+1,-1);
        vector<int> maxYforX(n+1,-1);
        for( auto& v:arr){
            int r=v[0];
            int c=v[1];
            minXforY[c]=(minXforY[c]==-1) ? r:min(r,minXforY[c]);
            maxXforY[c]=(minXforY[c]==-1) ? r:max(r,maxXforY[c]);
            minYforX[r]=(minYforX[r]==-1) ? c:min(c,minYforX[r]);
            maxYforX[r]=(maxYforX[r]==-1) ? c:max(c,maxYforX[r]);
        }
        int ans=0;
        for(auto& v:arr){
            int r=v[0];
            int c=v[1];
            if(minXforY[c]<r && maxXforY[c]>r && minYforX[r]<c  && maxYforX[r]>c ){
                ans++;
            }
        }
        return ans;
    }
};