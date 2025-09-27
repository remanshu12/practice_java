class Solution {
    public String frequencySort(String s) {
        TreeMap<Character,Integer> map=new TreeMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        StringBuilder sb=new StringBuilder();
        PriorityQueue<Character> pq=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        for(char c:map.keySet()){
            pq.add(c);
            System.out.println(c);
        }
        while(!pq.isEmpty()){
            char c=pq.poll();
            int freq=map.get(c);
            for(int i=0;i<freq;i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}