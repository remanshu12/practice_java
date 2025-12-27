class Solution {
    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        int n = arrivals.length;
        if (n == 0) return 0;
        Map<Integer, Integer> count = new HashMap<>();
        int[] keep = new int[n];
        int removed = 0;
        for (int i = 0; i < n; i++) {
            int out = i - w;
            if (out >= 0 && keep[out] == 1) {
                int val = arrivals[out];
                count.put(val, count.get(val) - 1);
            }
            int cur = arrivals[i];
            if (count.getOrDefault(cur, 0) < m) {
                keep[i] = 1;
                count.put(cur, count.getOrDefault(cur, 0) + 1);
            } else {
                removed++;
            }
        }
        return removed;
    }
}
