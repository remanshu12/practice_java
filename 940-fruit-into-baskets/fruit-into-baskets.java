class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> map=new HashMap<>();
        int left=0;
        int right=0;
        int maxlen=Integer.MIN_VALUE;
        while(right<fruits.length){
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);

            while(map.size()>2){
                map.put(fruits[left],map.get(fruits[left])-1);
                if(map.get(fruits[left])==0){
                    map.remove(fruits[left]);
                }
                left++;
            }
            if(map.size()<=2){
                maxlen=Math.max(maxlen,right-left+1);
                right++;
            }
        }
        return maxlen;
    }
}