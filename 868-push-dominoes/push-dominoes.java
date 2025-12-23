class Solution {
    public String pushDominoes(String arr) {
         int n=arr.length();
       int[] leftToright=new int[n];
        int[] rightToleft=new int[n];
        for(int i=0;i<n;i++){
            if(arr.charAt(i)=='R'){
                leftToright[i]=i;
            }else if(arr.charAt(i)=='L'){
                leftToright[i]=-1;
            }else if(arr.charAt(i)=='.'){
                leftToright[i]=i>0?leftToright[i-1]:-1;
            }
        }
        for(int i=n-1;i>=0;i--){
            if(arr.charAt(i)=='L'){
                rightToleft[i]=i;
            }else if(arr.charAt(i)=='R'){
                rightToleft[i]=-1;
            }else if(arr.charAt(i)=='.'){
                rightToleft[i]=i<n-1?rightToleft[i+1]:-1;
            }
        }
        char[] result=new char[n];
        for(int i=0;i<n;i++){
            int distLtoR=Math.abs(i-leftToright[i]);
            int distRtoL=Math.abs(i-rightToleft[i]);
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
        String ans=new String(result);
        return ans;
    }
}