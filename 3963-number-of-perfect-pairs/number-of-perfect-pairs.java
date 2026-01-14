class Solution {
    public long perfectPairs(int[] nums) {
        long[] arr = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = Math.abs((long)nums[i]);
        }
        Arrays.sort(arr);
        long count = 0;
        int right = 0;
        for (int left = 0; left < arr.length; left++) {
            if (right < left) {
                right = left;
            }
            while (right + 1 < arr.length && arr[right + 1] <= 2 * arr[left]) {
                right++;
            }
            count += (right - left);
        }  
        return count;
    }
}