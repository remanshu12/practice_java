class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        ArrayList<Integer> r1 = new ArrayList<>(), r2 = new ArrayList<>();

        for (int x : nums) {
            sum += x;
            if (x % 3 == 1) r1.add(x);
            else if (x % 3 == 2) r2.add(x);
        }
        if (sum % 3 == 0) return sum;

        Collections.sort(r1);
        Collections.sort(r2);

        int rem = sum % 3;
        int remv = Integer.MAX_VALUE;

        if (rem == 1) {
            if (r1.size() >= 1) remv = Math.min(remv, r1.get(0));
            if (r2.size() >= 2) remv = Math.min(remv, r2.get(0) + r2.get(1));
        } else {
            if (r2.size() >= 1) remv = Math.min(remv, r2.get(0));
            if (r1.size() >= 2) remv = Math.min(remv, r1.get(0) + r1.get(1));
        }
        return remv == Integer.MAX_VALUE ? 0 : sum - remv;
    }
}
