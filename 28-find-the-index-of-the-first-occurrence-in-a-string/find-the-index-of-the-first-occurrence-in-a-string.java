class Solution {
    public int strStr(String haystack, String needle) {
        int haylength=haystack.length();
        int needlelen=needle.length();
        if(haylength<needlelen){
            return -1;
        }
        for(int i=0;i<=haylength-needlelen;i++){
            int j=0;
            while(j<needle.length() && haystack.charAt(i+j)==needle.charAt(j)){
                j++;
                if(j==needlelen){
                    return i;
                }
            }
        }
        return -1;
    }
}