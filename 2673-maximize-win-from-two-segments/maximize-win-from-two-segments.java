class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
        
        int n = prizePositions.length;
        int leftMax[] = new int[n];
        int rightMax[] = new int[n];

        leftMax[0] = 1;
        for(int i = 1, j = 0; i < n; i++) {
            while(prizePositions[i] - prizePositions[j] > k) {
                j++;
            }
            leftMax[i] = Math.max(leftMax[i-1], i-j+1);
        }

        rightMax[n-1] = 1;
        for(int i = n-2, j = n-1; i >= 0; i--) {
            while(prizePositions[j] - prizePositions[i] > k) {
                j--;
            }
            rightMax[i] = Math.max(rightMax[i+1], j-i+1);
        }
        int res=0 ;
        for(int i=0; i <= n; i++) {
            res = Math.max(res,(i==0?0:leftMax[i- 1]) + (i == n ? 0 : rightMax[i]));
        }
        return res;
    }
}