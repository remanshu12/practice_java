class Solution {
public:
    int minZeroArray(vector<int>& nums, vector<vector<int>>& queries) {
        int low=0;
        bool alreadyZero = true;
        for(int x : nums) if(x > 0) alreadyZero = false;
        if(alreadyZero) return 0;
        int high=queries.size()-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(check(mid,nums,queries)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans==-1?-1:ans+1;
    }
     bool check(int last ,vector<int>& nums,vector<vector<int>>& que){
        int n=nums.size();
        vector<int> ans(n+1,0);
        for(int i=0;i<=last;i++){
            int a=que[i][0];
            int b=que[i][1];
            int val=que[i][2];
            ans[a]+=val;
            ans[b+1]+=-val;
        }
        for(int i=0;i<n;i++){
            if(i>0)
            ans[i]=ans[i]+ans[i-1];
            if(nums[i]>ans[i]){
                return false;
            }
        }
        return true;
    }
};