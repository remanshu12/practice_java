class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result=new ArrayList<>();
        String pre="";
        for(String w:words){
            char[] arr=w.toCharArray();
            Arrays.sort(arr);
            String curr=new String(arr);
            if(!curr.equals(pre)){
                result.add(w);
                pre=curr;
            }
        }
        return result;
    }
}