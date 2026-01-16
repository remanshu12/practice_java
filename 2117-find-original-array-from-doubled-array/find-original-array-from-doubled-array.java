class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 != 0) return new int[0];

        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : changed)
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        
           if (freq.containsKey(0) && freq.get(0) % 2 != 0)
            return new int[0];
            
        Arrays.sort(changed);
        int[] original = new int[n / 2];
        int idx = 0;

        for (int x : changed) {
            if (freq.get(x) == 0) continue;

            int twice = x * 2;
            if (!freq.containsKey(twice) || freq.get(twice) == 0)
                return new int[0];

            original[idx++] = x;
            freq.put(x, freq.get(x) - 1);
            freq.put(twice, freq.get(twice) - 1);
        }
        return original;
    }
}
