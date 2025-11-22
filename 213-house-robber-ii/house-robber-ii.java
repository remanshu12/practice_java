import java.util.*;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        // Case 1: rob from 0 to n-2
        // Case 2: rob from 1 to n-1
        return Math.max(helper(nums, 0, n - 1), helper(nums, 1, n));
    }

    static int helper(int[] nums, int start, int end) {
        int[] dp = new int[end]; // only for this range
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i < end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        
        return dp[end - 1];
    }
}
