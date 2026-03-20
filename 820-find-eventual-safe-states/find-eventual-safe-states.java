class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        int n=graph.length;
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        int indegree[]=new int[n];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int nd:graph[i]){
                list.get(nd).add(i);
                indegree[i]++;
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr=q.poll();
              ans.add(curr);
            for(int nd:list.get(curr)){
                indegree[nd]--;
                if(indegree[nd]==0){
                  
                    q.add(nd);
                }
            }
        }
        Collections.sort(ans);
        return ans;
        
    }
}