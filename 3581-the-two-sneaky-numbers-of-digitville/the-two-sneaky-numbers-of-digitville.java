class Solution {
    public int[] getSneakyNumbers(int[] arr1) {
       int[] arr=new int[2];
        HashMap<Integer,Integer> map=new HashMap<>();
      for(int i=0;i<arr1.length;i++){
            map.put(arr1[i],map.getOrDefault(arr1[i],0)+1);
        }
        int c=0;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        for(int num: set){
           if((map.get(num))==2){
            arr[c++]=num;
           }
        }

    
return arr;
    }
}