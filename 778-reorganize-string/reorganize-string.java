class Solution {
    public String reorganizeString(String s) {
         Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
         PriorityQueue<Character> pq = new PriorityQueue<>(
            (a, b) -> freq.get(b) - freq.get(a)
        );
        pq.addAll(freq.keySet());

          StringBuilder sb = new StringBuilder();
          Character prev = null; 
          while(!pq.isEmpty()){

          char curr=pq.poll();
          sb.append(curr);
          freq.put(curr,freq.get(curr)-1);
        
          if(prev!=null && freq.get(prev)>0){
            pq.add(prev);
          }
          prev=curr;
          
          }
          return sb.length()==s.length()?sb.toString() : "";
    }
}