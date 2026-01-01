class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        temp.add(0);
        plku(list,graph,0,graph.length-1,temp);
        return list;
    }
    static void plku( List<List<Integer>> list,int[][] graph, int s , int e,List<Integer> temp){
        if(s==e){
            list.add(new ArrayList<>(temp));
            return ;
        }
       
        
        for(int ed:graph[s]){
           
                temp.add(ed);
                plku(list,graph,ed,e,temp);
                temp.remove(temp.size()-1);
            
        }
       
    }
}