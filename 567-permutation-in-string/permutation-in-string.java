import java.util.*;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        // sorted version of s1
        char[] arr = s1.toCharArray();
        Arrays.sort(arr);
        String sortedS1 = new String(arr);

        // sliding window of length s1
        StringBuilder window = new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {
            window.append(s2.charAt(i));
        }

        if (match(sortedS1, window.toString())) return true;

        for (int i = s1.length(); i < s2.length(); i++) {
            window.deleteCharAt(0);           // remove first char
            window.append(s2.charAt(i));      // add new char

            if (match(sortedS1, window.toString())) return true;
        }
        return false;
    }

    static boolean match(String sortedS1, String windowStr) {
        char[] arr1 = sortedS1.toCharArray();
        char[] arr2 = windowStr.toCharArray();
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
}