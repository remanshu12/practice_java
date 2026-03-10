class Solution {
    public String minWindow(String s, String t) {

        int[] map = new int[128];

        for(char c : t.toCharArray()){
            map[c]++;
        }

        int left = 0;
        int right = 0;
        int required = t.length();

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while(right < s.length()){

            char c = s.charAt(right);

            if(map[c] > 0)
                required--;

            map[c]--;
            right++;

            while(required == 0){

                if(right - left < minLen){
                    minLen = right - left;
                    start = left;
                }

                char lc = s.charAt(left);

                map[lc]++;

                if(map[lc] > 0)
                    required++;

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}