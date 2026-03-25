class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
         int indgree[]=new int[n];
          ArrayList<Integer> list=new ArrayList<>();
        if (n == 1) {
            list.add(0);
            return list;
        }
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] ed : edges) {
            int u = ed[0];
            int v = ed[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            indgree[u]++;
            indgree[v]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indgree[i]==1)
            q.add(i);
        }
       int total=n;
       while(total>2){
           int size=q.size();
           total-=size;
           for(int i=0;i<size;i++){
               int curr=q.poll();
               for(int nei:adj.get(curr)){
                   indgree[nei]--;
                   if(indgree[nei]==1){
                       q.add(nei);
                   }
               }
           }
       }
     //  ArrayList<Integer> list=new ArrayList<>();
       while(!q.isEmpty()){
           list.add(q.poll());
       }
       return list;
       
    }
}