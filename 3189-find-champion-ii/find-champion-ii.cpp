class Solution {
public:
    int findChampion(int n, vector<vector<int>>& edges) {
        unordered_set<int> set;
        for(int i=0;i<edges.size();i++){
            set.insert(edges[i][1]);
        }
        int count=0;
        int val=0;
        for(int i=0;i<n;i++){
            if(set.find(i)==set.end()){
                val=i;
                count++;
            }
        }
        if(count==1){
            return val;
        }
        return -1;
    }
};