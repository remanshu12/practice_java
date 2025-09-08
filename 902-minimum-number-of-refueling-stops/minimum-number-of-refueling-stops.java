class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        if(startFuel>=target){
            return 0;
        }
        if(startFuel<target && stations.length==0){
          
            return -1;
        }
        int count=0;
        int i=0;
       while(startFuel<target && i<stations.length){
            int pos=stations[i][0];
            if(pos<=startFuel){
                pq.add(stations[i][1]);
                i++;
            }else{
                if(pq.isEmpty()){
                    return -1;
                }
                startFuel+=pq.poll();
                count++;
            }
       }
        if(startFuel>=target){
        return count;
       }
       while(!pq.isEmpty()){
        startFuel+=pq.poll();
        count++;
         if(startFuel>=target){
        return count;
       }
       }
      
        return -1;
    

    }
}