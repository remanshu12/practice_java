class Solution {
    public String longestNiceSubstring(String s){
        String ans="";
        int max=0;
        for(int i=0;i<s.length()-1;i++){
            for(int j=i+1;j<s.length();j++){
                String curr =(s.substring(i,j+1));
               if(check(curr)){
                if(curr.length()>max){
                    max=curr.length();
                    ans=curr;
                }
               }
            }
        }
        return ans;


    }
    static boolean check(String sb){
        Set<Character> set=new HashSet<>();
        for(char c:sb.toCharArray()){
            set.add(c);
        }
        for(char c: set){
            if(Character.isLowerCase(c) && !set.contains(Character.toUpperCase(c))){
                return false;
            }
             if(Character.isUpperCase(c) && !set.contains(Character.toLowerCase(c))){
                return false;
            }
        }
        return true;
    }
}