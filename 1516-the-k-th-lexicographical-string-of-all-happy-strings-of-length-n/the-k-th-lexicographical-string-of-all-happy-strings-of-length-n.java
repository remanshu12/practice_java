class Solution {

    int count = 0;
    String ans = "";

    public String getHappyString(int n, int k) {
        backtrack(n, k, new StringBuilder());
        return ans;
    }

    void backtrack(int n, int k, StringBuilder sb) {

        if (sb.length() == n) {
            count++;
            if (count == k) {
                ans = sb.toString();
            }
            return;
        }

        char[] chars = {'a', 'b', 'c'};

        for (char ch : chars) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ch)
                continue;

            sb.append(ch);
            backtrack(n, k, sb);

            if (!ans.equals("")) return; // stop early when kth found

            sb.deleteCharAt(sb.length() - 1);
        }
    }
}