class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k = (long) k1 + k2;
        int n = nums1.length;
        
        // Use a frequency array. Assuming max value in nums is 10^5.
        // If values are larger, use a TreeMap or Binary Search.
        int maxDiff = 0;
        int[] diffs = new int[n];
        long totalDiffSum = 0;

        for (int i = 0; i < n; i++) {
            diffs[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diffs[i]);
            totalDiffSum += diffs[i];
        }

        // Optimization: If k is enough to reduce all diffs to 0, return 0 immediately.
        if (totalDiffSum <= k) return 0;

        // Create buckets where buckets[i] is the count of pairs with difference 'i'
        int[] buckets = new int[maxDiff + 1];
        for (int diff : diffs) {
            buckets[diff]++;
        }

        // Iterate from the largest difference downwards
        for (int i = maxDiff; i > 0 && k > 0; i--) {
            if (buckets[i] == 0) continue;

            long count = buckets[i]; 

            if (k >= count) {
                // We have enough k to reduce ALL elements of value 'i' to 'i-1'
                buckets[i] -= count;   // Remove them from current bucket
                buckets[i - 1] += count; // Move them to the bucket below
                k -= count;
            } else {
                // We run out of k; we can only reduce 'k' elements
                buckets[i] -= k;     // 'k' items are reduced
                buckets[i - 1] += k; // They move to 'i-1'
                k = 0;               // Done
            }
        }

        // Calculate sum of squares
        long sum = 0;
        for (int i = 1; i <= maxDiff; i++) {
            if (buckets[i] > 0) {
                sum += (long) buckets[i] * i * i;
            }
        }

        return sum;
    }
}