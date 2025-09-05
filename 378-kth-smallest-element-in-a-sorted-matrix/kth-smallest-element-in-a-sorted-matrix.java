class Solution {
    class pair{
            int val;
            int row;
            int col;
            pair(int v,int r,int c){
                val=v;
                row=r;
                col=c;
            }
        }
    public int kthSmallest(int[][] mat, int k) {
        // code here
        int n=mat.length;
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        for(int i=0;i<n;i++){
            pq.add(new pair(mat[i][0],i,0));
        }
        pair curr=null;
        while(k-- >0){
             curr=pq.poll();
            if(curr.col+1<n){
                pq.add(new pair(mat[curr.row][curr.col+1],curr.row,curr.col+1));
            }
        }
        return curr.val;
    }
}
