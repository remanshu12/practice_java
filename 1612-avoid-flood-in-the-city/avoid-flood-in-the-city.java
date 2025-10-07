class Solution {
    public int[] avoidFlood(int[] arr) {
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        TreeSet<Integer> set=new TreeSet<>();
          int ans[]=new int[arr.length];
         Arrays.fill(ans, 1);
      
        for(int i=0;i<arr.length;i++){
           if(arr[i]==0){
            set.add(i);
            
           }else{
            ans[i]=-1;

            if(map.containsKey(arr[i])){
                int it=map.get(arr[i]);
                 Integer dryDay = set.higher(it);
                 if(dryDay==null){
                    return new int[]{};
                 }
                 ans[dryDay]=arr[i];
                 set.remove(dryDay);
            }
            map.put(arr[i],i);
           }
        }
        return ans;

    }
}