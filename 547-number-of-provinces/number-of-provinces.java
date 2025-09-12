class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = isConnected.length;

        // build adjacency list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int visited[] = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                count++;
                dfs(visited, adj, i);
            }
        }
        return count;
    }

    static void dfs(int visited[], ArrayList<ArrayList<Integer>> adj, int curr) {
        visited[curr] = 1;
        for (int neighbor : adj.get(curr)) {
            if (visited[neighbor] == 0) {
                dfs(visited, adj, neighbor);
            }
        }
    }
}
