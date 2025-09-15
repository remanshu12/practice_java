class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] arr=text.split(" ");
        Set<Character> broken=new HashSet<>();
        for( char ch: brokenLetters.toCharArray()){
            broken.add(ch);
        }
        int ans=0;
        for(String s: arr){
            boolean flag=true;
            for(char ch:s.toCharArray()){
                if(broken.contains(ch)){
                    flag=false;
                    break;
                }
            }
            if(flag)
                ans++;
        }
        return ans;
    }
}