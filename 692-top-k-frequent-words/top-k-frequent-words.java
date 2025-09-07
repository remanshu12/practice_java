class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map=new HashMap<>();
        for(String i: words){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<String> pq=new PriorityQueue<>((a,b)->map.get(a).equals(map.get(b)) ?
        b.compareTo(a): map.get(a)-map.get(b));

        for(String word:map.keySet()){
            pq.add(word);
            if(pq.size()>k){
                pq.poll();
            }
        }

        List<String> result=new ArrayList<>();
        while(!pq.isEmpty()){
            result.add(pq.poll());

        }
        Collections.reverse(result);
        return result;
    }
}