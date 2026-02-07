class Solution {
public:
    int minimumDeletions(string s) {
        int count=0;
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(s[i]=='b'){
                count++;
            }else if(count>0){
                ans+=1;
                count-=1;
            }
        }
        return ans;
    }
};