class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char t : tasks) {
            freq[t - 'A']++;
        }
        int maxFreq = 0;
        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }
        int countMax = 0;
        for (int f : freq) {
            if (f == maxFreq) {
                countMax++;
            }
        }
        int part1 = (maxFreq - 1) * (n + 1) + countMax;
        return Math.max(part1, tasks.length);
    }
}
