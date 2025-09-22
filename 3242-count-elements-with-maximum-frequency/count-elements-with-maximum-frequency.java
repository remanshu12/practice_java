class Solution {
    public int maxFrequencyElements(int[] nums) {
      
        int[] arr = new int[101];
        for (int num : nums) {
            arr[num]++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int frequency : arr) {
            if (frequency > 0) { 
                pq.add(frequency);
            }
        }

        int count = 0;
        if (!pq.isEmpty()) { 
            int topFrequency = pq.peek(); 
            while (!pq.isEmpty() && pq.peek() == topFrequency) {
                count += pq.poll();
            }
        }
        
        return count;      
    }
}