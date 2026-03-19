class Solution {
    public boolean canFinish(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int ed[]:edges){
            list.get(ed[0]).add(ed[1]);
        }
        Queue<Integer> q=new LinkedList<>();
        int indegree[]=new int[n];
        for(int i=0;i<n;i++){
            for(int node:list.get(i)){
                indegree[node]++;
            }
        }
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int count=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            count++;
            for(int nd:list.get(curr)){
                indegree[nd]--;
                if(indegree[nd]==0){
                    q.add(nd);
                }
            }
        }
        return count==n;
    }
}