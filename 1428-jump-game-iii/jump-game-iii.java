class Solution {
    public boolean canReach(int[] arr, int start) {
        int n=arr.length;
        int visited[]=new int[n];
        visited[start]=1;
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int curr=q.poll();

            if(curr+arr[curr]<n && arr[curr+arr[curr]]==0 ){
                return true;
            }
            if(curr-arr[curr]>=0 && arr[curr-arr[curr]]==0){
                return true;
            }
            if(curr+arr[curr]<n && visited[curr+arr[curr]]==0){
                visited[curr+arr[curr]]=1;
                q.add(curr+arr[curr]);
            }
             if(curr-arr[curr]>=0 && visited[curr-arr[curr]]==0){
                visited[curr-arr[curr]]=1;
                q.add(curr-arr[curr]);
            }

        }
        return false;
    }
}