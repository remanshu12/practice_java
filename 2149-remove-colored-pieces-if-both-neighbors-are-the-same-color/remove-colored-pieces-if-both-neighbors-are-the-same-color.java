class Solution {
    public boolean winnerOfGame(String colors) {
        int count_a = 0;
        int count_b = 0;
        int a = 0;
        int b = 0;

        for (int i = 0; i < colors.length(); i++) {
            char c = colors.charAt(i);
            
            if (c == 'A') {
                a++;
                b = 0; // reset B sequence
                if (a >= 3) count_a++;
            } else {
                b++;
                a = 0; // reset A sequence
                if (b >= 3) count_b++;
            }
        }

        return count_a > count_b;
    }
}
