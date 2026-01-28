class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        List<List<Integer>> map=new ArrayList<>();
        for(int i=0;i<101;i++){
            map.add(new ArrayList<>());
        }
        for(int i=0;i<rectangles.length;i++){
            map.get(rectangles[i][1]).add(rectangles[i][0]);
        }
        for(int i=0;i<101;i++){
            Collections.sort(map.get(i));
        }
        int res[]=new int[points.length];
        for(int i=0;i<points.length;i++){
            int count=0;
            for(int j=points[i][1];j<map.size();j++){
                List<Integer> list= map.get(j);
                if(list.isEmpty()) continue;
                int index=binarysearch(list,points[i][0]);
                if(index==-1) index=list.size();
                count+=list.size()-index;
            }
            res[i]=count;
        }
        return res;

    }
    static int binarysearch(List<Integer> list,int key){
        int low=0;
        int high=list.size()-1;
        int ans=-1;
        while(low<= high){
            int mid=low+(high-low)/2;
            if(list.get(mid)>=key){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}