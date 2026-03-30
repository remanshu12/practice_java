class Solution {
    public boolean checkStrings(String s1, String s2) {
        int odd[]=new int[26];
        int even[]=new int[26];
        int n=s1.length();
        for(int i=0;i<n;i++){
            if(i%2==0){
                even[s1.charAt(i)-'a']++;
            }else{
                odd[s1.charAt(i)-'a']++;
            }
        }
        for(int i=0;i<n;i++){
            if(i%2==0){
                even[s2.charAt(i)-'a']--;
                if(even[s2.charAt(i)-'a']<0) return false;
            }else{
                odd[s2.charAt(i)-'a']--;
                if(odd[s2.charAt(i)-'a']<0) return false;
            }
        }
        return true;
    }
}