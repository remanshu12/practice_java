class Solution {
    public int subarraySum(int[] arr, int k) {
        int[] pri =new int[arr.length];
        pri[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            pri[i]=arr[i]+pri[i-1];
        }
        Map<Integer,Integer> p = new HashMap();
        int count=0;
         p.put(0, p.getOrDefault(0, 0) + 1); 
        for(int j=0;j<arr.length;j++){
          
            int val=pri[j]-k;
            if(p.containsKey(val)){
             count += p.get(val);   
            }
          p.put(pri[j], p.getOrDefault(pri[j], 0) + 1);  
        }
        return count;
        

    }
}