class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        HashMap<Integer, Boolean> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (dfs(map, i, graph)) {
                result.add(i);
            }
        }
        
        return result;
    }

    static boolean dfs(HashMap<Integer, Boolean> map, int node, int[][] graph) {
        if (map.containsKey(node)) {
            return map.get(node); // already computed
        }

        // mark as "in progress" (cycle detection)
        map.put(node, false);

        for (int nei : graph[node]) {
            if (!dfs(map, nei, graph)) {
                return false; // if any neighbor is unsafe, this node is unsafe
            }
        }

        // mark as safe
        map.put(node, true);
        return true;
    }
}
