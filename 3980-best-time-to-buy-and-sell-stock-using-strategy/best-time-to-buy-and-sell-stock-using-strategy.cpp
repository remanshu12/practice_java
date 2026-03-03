class Solution {
public:
    long long maxProfit(vector<int>& prices, vector<int>& strategy, int k) {
        int n=prices.size();
        long long ans=0;
        vector<long long> org(n+1,0);
        for(int i=1;i<=n;i++){
            org[i]=org[i-1]+prices[i-1];
        }
         vector<long long> modify(n+1,0);
        for(int i=1;i<=n;i++){ 
            modify[i]=modify[i-1]+(prices[i-1]*strategy[i-1]);
        }
//         for(int i = 0; i <=n; i++) {
//     cout << org[i] << " ";
// }
// for(int i = 0; i <=n; i++) {
//     cout << modify[i] << " ";
// }
        int i=1;
        ans=modify[n];
        long long sum=0;
        //cout << '\n';
        n=n+1;
        while(i+k<=n){
            sum=0;
            sum+=modify[i-1];
           // cout << sum <<" ";
            sum+=(org[i+k-1]-org[i+k/2-1]);
           // cout << sum <<" ";
            sum+=(modify[n-1]-modify[i+k-1]);
            //cout << sum <<" ";
            ans=max(ans,sum);
            i++;
        }
        return ans;

    }
};