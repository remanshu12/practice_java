class Solution {
    public int strStr(String s1, String s2) {
        int lps[]=new int[s2.length()];
        lps[0]=0;
        int i=1;
        int length=0;
        while(i<s2.length()){
            if(s2.charAt(length)==s2.charAt(i)){
                length++;
                lps[i]=length;
                i++;
            }else{
                if(length!=0){
                    length=lps[length-1];
                }else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        i=0;
        int j=0;
        while(i<s1.length()){
            if(s1.charAt(i)==s2.charAt(j)){
               i++;
                j++;
            }else{
                if(j!=0)
                j=lps[j-1];
                else{
                    i++;
                }
            }
            if(j==s2.length()){
                return i-s2.length();
                
            }
        }
        return -1;
    }
}