import java.util.HashMap;

class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        // Map stores: Key = Number value, Value = Length of chain ending at that number
        HashMap<Integer, Integer> dp = new HashMap<>();
        int maxLen = 1;

        for (int num : arr) {
            // Find out what the previous number in the sequence should be
            int prevNum = num - difference;
            
            // If we have seen a chain ending with 'prevNum', extend it.
            // If not, dp.getOrDefault returns 0, so we start with 0 + 1 = 1.
            int len = dp.getOrDefault(prevNum, 0) + 1;
            
            // Store the new length for the current number
            dp.put(num, len);
            
            // Update the global maximum
            maxLen = Math.max(maxLen, len);
        }
        
        return maxLen;
    }
}