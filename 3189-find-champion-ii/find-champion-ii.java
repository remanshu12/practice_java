class Solution {
    public int findChampion(int n, int[][] edges) {
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<edges.length;i++){
            set.add(edges[i][1]);
        }
        int count=0;
        int val=0;
        for(int i=0;i<n;i++){
            if(!set.contains(i)){
                val=i;
                count++;
            }
        }
        if(count==1){
            return val;
        }
        return -1;
    }
}