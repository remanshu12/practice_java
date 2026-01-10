class Solution {
    public int longestSubsequence(int[] arr, int diff) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int maxlen=1;
        for(int num:arr){
            int pre=num-diff;
            int len=map.getOrDefault(pre,0)+1;
            map.put(num,len);
            maxlen=Math.max(maxlen,len);
        }
        return maxlen;
    }
}