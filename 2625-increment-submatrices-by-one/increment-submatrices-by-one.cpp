class Solution {
public:
    vector<vector<int>> rangeAddQueries(int n, vector<vector<int>>& queries) {
        vector<vector<int>> ans(n,vector<int>(n));
        for(vector<int> arr:queries){
            for(int i=arr[0];i<=arr[2];i++){
               ans[i][arr[1]]++;
                int temp=i;
                if(arr[3]+1 >n-1){
                    temp=i+1;
                }if(temp>n-1){
                    continue;
                }
                ans[temp][(arr[3]+1)%n]--;
            }
        }
        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sum+=ans[i][j];
                ans[i][j]=sum;
            }
        }
        return ans;
    }
};