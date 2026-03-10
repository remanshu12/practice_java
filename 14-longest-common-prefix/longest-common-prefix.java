class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int start=strs[0].length();
        int end=strs[strs.length-1].length();
        StringBuilder sb=new StringBuilder();
        int len=Math.min(start,end);
        for(int i=0;i<len;i++){
            if(strs[0].charAt(i)==strs[strs.length-1].charAt(i)){
                sb.append(strs[0].charAt(i));
            }else{
                break;
            }
        }
        return sb.toString();
    }
}