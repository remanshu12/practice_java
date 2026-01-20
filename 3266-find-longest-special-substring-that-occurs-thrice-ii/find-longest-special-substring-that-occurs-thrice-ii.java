class Solution {
    public int maximumLength(String s) {
        int low=1;
        int ans=-1;
        int high=s.length()-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(check(s,mid)){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
    static boolean check(String s,int val){
        int arr[]=new int[27];
        int count=1;
        for(int i=0;i<s.length();i++){
            if(i>0 && s.charAt(i)==s.charAt(i-1)){
                count++;
            }else{
                count=1;
            }
            if(count>=val){
                arr[s.charAt(i)-'a']++;
            }
            if(arr[s.charAt(i)-'a']>=3){
                return true;
            }
        }
        return false;
    }
}