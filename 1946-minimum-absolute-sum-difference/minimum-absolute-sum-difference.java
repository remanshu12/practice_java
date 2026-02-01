import java.util.Arrays;

class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int mod = 1000000007;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.abs(nums1[i] - nums2[i]);
        }
        if (sum == 0) return 0;
        int[] sorted = nums1.clone();
        Arrays.sort(sorted);
        int maxDec = 0;
        for (int i = 0; i < n; i++) {
            int currDiff = Math.abs(nums1[i] - nums2[i]);
            int closestDiff = getClosest(sorted, nums2[i]);
            int save = currDiff - closestDiff;
            maxDec = Math.max(maxDec, save);
        }
        return (int) ((sum - maxDec) % mod);
    }
    private int getClosest(int[] arr, int val) {
        int l = 0;
        int r = arr.length - 1; 
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == val) return 0;
            if (arr[mid] < val) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        int minVal = Integer.MAX_VALUE;
        if (l < arr.length) {
            minVal = Math.min(minVal, Math.abs(arr[l] - val));
        }
        if (r >= 0) {
            minVal = Math.min(minVal, Math.abs(arr[r] - val));
        }
        return minVal;
    }
}