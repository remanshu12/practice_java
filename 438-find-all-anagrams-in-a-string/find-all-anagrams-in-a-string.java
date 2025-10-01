class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> lst=new ArrayList<>();
        if(s.length()<p.length()){
            return lst;
        }
        char[] arr=new char[26];
        char[] arr2=new char[26];
        for(int i=0;i<p.length();i++){
            arr[p.charAt(i)-'a']++;
            arr2[s.charAt(i)-'a']++;
        }
        if(match(arr,arr2)){
            lst.add(0);
        }
        for(int i=p.length();i<s.length();i++){
            arr2[s.charAt(i)-'a']++;
            arr2[s.charAt(i-p.length())-'a']--;
            if(match(arr,arr2)){
                lst.add(i-p.length()+1);
            }
        }
        return lst;
    }
    static boolean match(char[] arr,char[] arr2){
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
}