class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        int visited[]=new int[graph.length];
        temp.add(0);
        plku(list,graph,0,graph.length-1,temp,visited);
        return list;
    }
    static void plku( List<List<Integer>> list,int[][] graph, int s , int e,List<Integer> temp,int[] visited){
        if(s==e){
            list.add(new ArrayList<>(temp));
            return ;
        }
        visited[s]=1;
        
        for(int ed:graph[s]){
            if(visited[ed]!=1){
                temp.add(ed);
                plku(list,graph,ed,e,temp,visited);
                temp.remove(temp.size()-1);
            }
        }
        visited[s]=0;

    }
}