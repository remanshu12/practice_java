class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int left=0;
        int right=0;
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='L'){
                left++;
            }else if(moves.charAt(i)=='R'){
                right++;
            }
        }
        int n=moves.length();

        return n-(left+right)+Math.abs(left-right);
    }
}