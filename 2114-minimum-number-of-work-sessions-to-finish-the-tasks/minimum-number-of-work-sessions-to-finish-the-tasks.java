//Approach -1
class Solution {
    private int minSessions;

    public int minSessions(int[] tasks, int sessionTime) {
        minSessions = tasks.length;
        int[] sessions = new int[tasks.length];
        backtrack(tasks.length - 1, tasks, sessions, sessionTime);
        return minSessions;
    }

    private void backtrack(int index, int[] tasks, int[] sessions, int sessionTime) {
        if (index < 0) {
            int usedSessions = 0;
            for (int session : sessions) {
                if (session > 0) usedSessions++;
            }
            minSessions = Math.min(minSessions, usedSessions);
            return;
        }
        for (int i = 0; i < sessions.length; i++) {
            if (i > 0 && sessions[i] == sessions[i-1]) continue;
            if (sessions[i] + tasks[index] <= sessionTime) {
                sessions[i] += tasks[index];
                backtrack(index - 1, tasks, sessions, sessionTime);
                sessions[i] -= tasks[index];
            }
            if (sessions[i] == 0) break;
        }
    }
}