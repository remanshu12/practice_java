class Solution {
    public int edgeScore(int[] arr) {
        HashMap<Long,Long> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put((long)arr[i],map.getOrDefault((long)arr[i],(long)0)+(long)i);
        }
        long value=0;
        long key=0;
        for(long i:map.keySet()){
            //System.out.println(i+" "+map.get(i));
           if(value<map.get(i)){
            value=map.get(i);
            key=i;
           }else if(value==map.get(i)){
            key=Math.min(key,i);
           }
        }
        return (int)key;
    }
}