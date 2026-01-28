class Solution {
public:
    vector<int> countRectangles(vector<vector<int>>& rectangles, vector<vector<int>>& points) {
        vector<vector<int>> list(101);
        for(auto &a:rectangles){
            list[a[1]].push_back(a[0]);
        }
        for(int i=0;i<101;i++){
            sort(list[i].begin(),list[i].end());
        }
        vector<int> res;
        for(auto &p:points){
            int count=0;
            for(int i=p[1];i<list.size();i++){
                if(list[i].empty()) continue;
                int index=lower_bound(list[i].begin(),list[i].end(),p[0])-list[i].begin();
                count+=list[i].size()-index;
            }
            res.push_back(count);
        }
        return res;
    }
};