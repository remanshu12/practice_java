import java.util.*;

class Solution {
    public String resultingString(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (!stack.isEmpty()) {
                char top = stack.peek();
                int diff = Math.abs(curr - top);

                // adjacent letters or a-z / z-a
                if (diff == 1 || diff == 25) {
                    stack.pop();
                    continue;
                }
            }

            stack.push(curr);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
