class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char arr[]=new char[26];
        char arr2[]=new char[26];
        if(s2.length()<s1.length()){
            return false;
        }
        for(int i=0;i<s1.length();i++){
            arr[s1.charAt(i)-'a']++;
            arr2[s2.charAt(i)-'a']++;
        }
        if(match(arr,arr2)){
            return true;
        }
        for(int i=s1.length();i<s2.length();i++){
            arr2[s2.charAt(i)-'a']++;
            arr2[s2.charAt(i-s1.length())-'a']--;
            if(match(arr,arr2)){
                return true;
            }
        }
        return false;
    }
    static boolean match(char arr[],char arr2[]){
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
}