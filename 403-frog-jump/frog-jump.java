class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer,HashSet<Integer>> map=new HashMap<>();
        for(int stone:stones){
            map.put(stone, new HashSet<>());
        }
        map.get(0).add(0);
        for(int i:stones){
            HashSet<Integer> set =map.get(i);
            for(int k:set){
                for(int j=k-1;j<=k+1;j++){
                    if(j>0 && map.containsKey(i+j)){
                        map.get(i+j).add(j);
                    }
                }
            }
        }
        return !map.get(stones[stones.length-1]).isEmpty();
    }
}