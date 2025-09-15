class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26]; 
        String vowels = "aeiou";
        boolean[] isVowel = new boolean[26];
        for (char v : vowels.toCharArray()) {
            isVowel[v - 'a'] = true;
        }
         for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

       
        int maxVowel = 0, maxConsonant = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                if (isVowel[i]) {
                    maxVowel = Math.max(maxVowel, freq[i]);
                } else {
                    maxConsonant = Math.max(maxConsonant, freq[i]);
                }
            }
        }

        return maxVowel + maxConsonant;
    }
}
