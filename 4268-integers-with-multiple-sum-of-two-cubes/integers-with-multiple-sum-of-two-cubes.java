class Solution {
    public List<Integer> findGoodIntegers(int n) {
        HashMap<Long,Integer> map=new HashMap<>();
        for(int i=0;i<=1000;i++){
            for(int j=0;j<=i;j++){
                long sum=((long)i*i*i + (long)j*j*j);
                if(sum>n) break;
                map.put(sum,map.getOrDefault(sum,0)+1);

            }
        }
        List<Integer> ans=new ArrayList<>();
        for(long key:map.keySet()){
            if(map.get(key)>=2){
                ans.add((int)key);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}