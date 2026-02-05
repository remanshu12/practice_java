class Solution {
public:
    vector<int> getSubarrayBeauty(vector<int>& nums, int k, int x) {
        int n=nums.size();
        vector<int> ans(n-k+1);
        map<int,int> mp;
        for(int i=0;i<k;i++){
            mp[nums[i]]++;
        }
        ans[0]=getx(mp,x);
        for(int i=k;i<n;i++){
            int start=nums[i-k];
            mp[start]--;
            if(mp[start]==0){
                mp.erase(start);
            }
            int end=nums[i];
            mp[end]++;
            ans[i-k+1]=getx(mp,x);
        }
        return ans;
    }
    int getx(map<int,int>& mp,int x){
        int count=0;
        for(auto& [num,freq]:mp){
            if(num>=0){
                break;
            }
            count+=freq;
            if(count>=x){
                return num;
            }
        }
        return 0;
    }
};