class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
    
    // dp[i] stores count of unique numbers with EXACTLY i digits
    int[] dp = new int[n + 1];
    
    // Base case: 1 digit numbers (1-9). We exclude 0 initially to make math easier.
    dp[1] = 9;
    
    int ans = 10; // Start with 10 because of the trivial 0-9 case for n=1
    
    for (int i = 2; i <= n; i++) {
        // Transition: previous count * available digits
        // For i=2, avail is 9. For i=3, avail is 8. Formula is (11 - i).
        dp[i] = dp[i-1] * (11 - i);
        
        ans += dp[i];
    }
    
    return ans;
    }
}