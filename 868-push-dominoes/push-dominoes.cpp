class Solution {
public:
    string pushDominoes(string arr) {
         int n=arr.length();
        vector<int> leftToright(n);
        vector<int> rightToleft(n);
        for(int i=0;i<n;i++){
            if(arr[i]=='R'){
                leftToright[i]=i;
            }else if(arr[i]=='L'){
                leftToright[i]=-1;
            }else if(arr[i]=='.'){
                leftToright[i]=i>0?leftToright[i-1]:-1;
            }
        }
        for(int i=n-1;i>=0;i--){
            if(arr[i]=='L'){
                rightToleft[i]=i;
            }else if(arr[i]=='R'){
                rightToleft[i]=-1;
            }else if(arr[i]=='.'){
                rightToleft[i]=i<n-1?rightToleft[i+1]:-1;
            }
        }
        string result(n,' ');
        for(int i=0;i<n;i++){
            int distLtoR=abs(i-leftToright[i]);
            int distRtoL=abs(i-rightToleft[i]);
            if(leftToright[i]==rightToleft[i]){
                result[i]='.';
            }else if(leftToright[i]==-1){
                result[i]='L';
            }else if(rightToleft[i]==-1){
                result[i]='R';
            }else if(distLtoR==distRtoL){
                 result[i]='.';
            }else {
                result[i]=distLtoR>distRtoL?'L':'R';
            }
            
        }
        return result;
    }
};