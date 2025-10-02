class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int compare = 1;
        for (int num : nums) {
            if (num == compare) {
                compare++; // found expected number, look for next
            }
        }
        return compare;
    }
}
