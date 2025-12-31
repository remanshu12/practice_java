class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<double[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            double p=succProb[i];
            adj.get(u).add(new double[]{v,p});
            adj.get(v).add(new double[]{u,p});
        }
        double[] prob=new double[n];
        prob[start]=1.0;
        PriorityQueue<double[]> pq=new PriorityQueue<>((a,b)->Double.compare(b[1],a[1]));
        pq.add(new double[]{start,1.0});
        while(!pq.isEmpty()){
            double[] curr=pq.poll();
            int node=(int)curr[0];
            double p=curr[1];
            if(node==end){
                return p;
            }
            if(p<prob[node]){
                continue;
            }
            for(double[] ad:adj.get(node)){
                int no=(int)ad[0];
                double cost=p*ad[1];
                if(cost>prob[no]){
                    prob[no]=cost;
                    pq.add(new double[]{no,cost});
                }
            }

        }
        return 0.0;
    }
}