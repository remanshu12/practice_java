class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
         List<List<Integer>> list=new ArrayList<>();
         int n=graph.length;
        
            ArrayList<Integer> ans=new ArrayList<>();
            ans.add(0);
          //  System.out.println(ans.size());
            dfs(0,list,n,ans,graph);
         
         return list;
    }
    static void dfs(int node,List<List<Integer>> list,int n,ArrayList<Integer> ans,int[][] graph){
        if(node==n-1){ 
            list.add(new ArrayList<>(ans));
            return;
        }
        for(int nd:graph[node]){
            ans.add(nd);
            
            dfs(nd,list,n,ans,graph);
             ans.remove(ans.size()-1);
        }
       
    }
}