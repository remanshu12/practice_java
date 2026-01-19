import java.util.*;

class Solution {
    public int totalSteps(int[] nums) {
        Stack<int[]> stack = new Stack<>();
        int result = 0;

        for (int num : nums) {
            int steps = 0;

            while (!stack.isEmpty() && stack.peek()[0] <= num) {
                steps = Math.max(steps, stack.pop()[1]);
            }

            if (stack.isEmpty()) {
                steps = 0;
            } else {
                steps += 1;
            }

            result = Math.max(result, steps);
            stack.push(new int[]{num, steps});
        }

        return result;
    }
}