class Solution {
    public int countCollisions(String s) {
        int i=0;
        int j=s.length()-1;
        int n=s.length();
        while(i<n && (s.charAt(i)=='L')){
            i++;
        }
        while(j>=0 && (s.charAt(j)=='R')){
            j--;
        }
        int count=0;
        for(int k=i;k<=j;k++){
            if(s.charAt(k)!='S'){
                count++;
            }
        }
        return count;
    }
}