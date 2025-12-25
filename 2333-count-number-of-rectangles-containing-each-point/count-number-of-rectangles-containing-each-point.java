class Solution {
    public int binarySearch(List<Integer> l , int x){
        int low=0;
        int high=l.size()-1;
        int ans=0;
        while(low<=high){
            int mid=(low+high)>>1;
            if(l.get(mid)>=x){
                ans=l.size()-mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        Arrays.sort(rectangles,(a,b)->a[0]-b[0]);
        Map<Integer,List<Integer>> map=new HashMap<>();
        int n=points.length;
        int[] ans=new int[n];
        for(int[] r:rectangles){
            int x=r[0], y=r[1];
            List<Integer> l = map.getOrDefault(y,new ArrayList<>());
            l.add(x);
            if(!map.containsKey(y)){
                map.put(y,l);    
            }
        }
        for(int i=0;i<n;i++){
            int x=points[i][0], y=points[i][1];
            int cnt=0;
            for(int j=100;j>=y;j--){
                if(map.containsKey(j)){
                    cnt+=binarySearch(map.get(j),x);
                }
            }
            ans[i]=cnt;
        }  
        return ans;
    }
}