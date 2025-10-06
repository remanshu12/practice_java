class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> ans=new ArrayList<>();
        helper(res,ans,s);
        return res;
    }
    static void helper(List<List<String>> res,List<String> ans,String s){
      if(s==""){
        res.add(new ArrayList<>(ans));
        return;
      }
      for(int i=0;i<s.length();i++){
        String last=s.substring(0,i+1);
        if(palindrome(last)){
            ans.add(last);
            helper(res,ans,s.substring(i+1));
            ans.remove(ans.size()-1);
        }
      }
    }
    static boolean palindrome(String s){
        int i=0;
        while(i<s.length()/2){
            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                return false;
            }i++;
        }
        return true;
    }
}