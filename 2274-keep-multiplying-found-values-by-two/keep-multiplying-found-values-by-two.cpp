class Solution {
public:
    int findFinalValue(vector<int>& nums, int original) {
        unordered_set<int> set;
        for(int num:nums){
            set.insert(num);
        }
        while(true){
            if(set.find(original)==set.end()){
                return original;
            }
            original*=2;
        }
    }
};