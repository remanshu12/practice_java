class Solution {
    public int characterReplacement(String s, int k) {
        int arr[]=new int[26];
        int max=0;int len=0;
        int i=0;
        for(int j=0;j<s.length();j++){
            arr[s.charAt(j)-'A']++;
            max=Math.max(arr[s.charAt(j)-'A'],max);
            if(( (j-i+1) - max ) > k ) {
                arr[s.charAt(i)-'A']--;
                i++;
            }
            len=Math.max(len,j-i+1);
        }
        return len;
    }
}