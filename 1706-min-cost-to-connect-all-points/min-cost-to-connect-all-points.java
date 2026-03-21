class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        ArrayList<ArrayList<int[]>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int dis=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                list.get(i).add(new int[]{j,dis});
                list.get(j).add(new int[]{i,dis});
            }
        }
        int sum=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        int visited[]=new int[n];
        pq.add(new int[]{0,0});
        while(!pq.isEmpty()){
            int curr=pq.peek()[1];
            int dis=pq.peek()[0];
            pq.poll();
            if(visited[curr]==1) continue;
            sum+=dis;
            visited[curr]=1;
            for(int it[]:list.get(curr)){
                if(visited[it[0]]==0){
                    pq.add(new int[]{it[1],it[0]});
                }
            }
        }
        return sum;
        
    }
}