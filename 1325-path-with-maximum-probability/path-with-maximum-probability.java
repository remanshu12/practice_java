class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
          ArrayList<ArrayList<double[]>> list=new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        int i=0;
        for(int t[]:edges){
            list.get(t[0]).add(new double[]{t[1],succProb[i]});
            list.get(t[1]).add(new double[]{t[0],succProb[i]});
            i++;
        }
        double dist[]=new double[n+1];
        Arrays.fill(dist,0);
    dist[start_node]=1.0;
    PriorityQueue<double[]> pq=new PriorityQueue<>((a,b)->Double.compare(b[0],a[0]));
    pq.add(new double[]{1,start_node});
    while(!pq.isEmpty()){
        double dis=pq.peek()[0];
        int node=(int)pq.peek()[1];
        pq.poll();
        for(double pair[]:list.get(node)){
                int nd=(int)pair[0];
                double duri=pair[1];
                if(dist[nd]<dis*duri){
                    dist[nd]=dis*duri;
                    pq.add(new double[]{dis*duri,nd});
                }
        }
    }
    System.out.println(Arrays.toString(dist));
    
  return dist[end_node];
    }
}