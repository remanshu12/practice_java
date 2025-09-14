class Solution {
    public int[] findOrder(int numCourses, int[][] arr) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pre : arr) {
            adj.get(pre[1]).add(pre[0]);
        }

        int[] vis = new int[numCourses];
        int[] pathvis = new int[numCourses];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numCourses; i++) {
            if (vis[i] == 0) {
                if (dfs(i, adj, vis, pathvis, stack)) {
                    // cycle detected → no valid order
                    return new int[0];
                }
            }
        }

        int[] order = new int[numCourses];
        int idx = 0;
        while (!stack.isEmpty()) {
            order[idx++] = stack.pop();
        }
        return order;
    }

    static boolean dfs(int node, ArrayList<ArrayList<Integer>> adj,
                       int[] vis, int[] pathvis, Stack<Integer> stack) {
        vis[node] = 1;
        pathvis[node] = 1;

        for (int nei : adj.get(node)) {
            if (vis[nei] == 0) {
                if (dfs(nei, adj, vis, pathvis, stack)) return true;
            } else if (pathvis[nei] == 1) {
                return true; // cycle found
            }
        }

        pathvis[node] = 0;
        stack.push(node);
        return false;
    }
}
