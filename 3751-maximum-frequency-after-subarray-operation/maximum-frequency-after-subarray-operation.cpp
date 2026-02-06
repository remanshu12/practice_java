class Solution {
public:
    int maxFrequency(vector<int>& nums, int k) {
        int count=0;
        bool arr[52]={false};
        for(int i:nums){
            if(i==k){
                count++;
                arr[i]=true;
            }
        }
        int maxi=0;
        for(int i=1;i<=50;i++){
            if(!arr[i] && i==k) continue;
            int curr=0;
            for(int num:nums){
                if(num==i){
                    curr++;
                }
                if(num==k){
                    curr--;
                }
                if(curr<0){
                    curr=0;
                }
                maxi=max(maxi,curr);
            }
            
        }
        return maxi+count;

    }
};