class Solution {
public:
    int minRemoval(vector<int>& nums, int k) {
        int i=0;
        int j=0;
        int n=nums.size();
        int maxi=INT_MIN;
        sort(nums.begin(),nums.end());
        while(i<n){
            while(j<n && (long)nums[i]*k>=nums[j]){
                j++;
            }
            maxi=max(maxi,j-i);
            i++;
        }
        return n-maxi;

    }
};