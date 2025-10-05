class Solution {
    public boolean predictTheWinner(int[] nums) {
        int sum=0;
        for(int i: nums){
            sum+=i;
        }
        int player1=solve(0,nums.length-1,nums);
        int player2=sum-player1;
        return player1>=player2;
    }
    static int solve(int i,int j,int[] nums){
        if(i>j){
            return 0;
        }
        if(i==j){
            return nums[j];
        }
        int possiblity_1_of_player_1=(nums[i]+Math.min(solve(i+2,j,nums),solve(i+1,j-1,nums)));
      int possiblity_2_of_player_1=(nums[j]+Math.min(solve(i,j-2,nums),solve(i+1,j-1,nums)));
      return Math.max(possiblity_1_of_player_1,possiblity_2_of_player_1);
    }
}