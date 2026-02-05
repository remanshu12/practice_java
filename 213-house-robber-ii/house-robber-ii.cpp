class Solution {
public:
    int check(vector<int> temp){
        int pre=temp[0];
        int pre2=0;
        int n=temp.size();
       
        for(int i=1;i<n;i++){
            int take=temp[i]+pre2;
            int nottake=pre;
            int curr=max(take,nottake);
            pre2=pre;
            pre=curr;
        }
        return pre;
    }
    int rob(vector<int>& nums) {
        vector<int> temp1,temp2;
        int n=nums.size();
            if (n == 0) return 0;
        if (n == 1) return nums[0];
        for(int i=0;i<n;i++){
            if(i!=0) temp1.push_back(nums[i]);
            if(i!=n-1) temp2.push_back(nums[i]);
            
        }
        return max(check(temp1),check(temp2));
    }
};