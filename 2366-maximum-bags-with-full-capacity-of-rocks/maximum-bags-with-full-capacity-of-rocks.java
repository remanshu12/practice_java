class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        for(int i=0;i<capacity.length;i++){
            capacity[i]=capacity[i]-rocks[i];
        }
        int count=0;
        Arrays.sort(capacity);
        for(int i=0;i<capacity.length;i++){

            if(capacity[i]==0){
                count++;
            }
           else if(capacity[i]>0){
                if(additionalRocks>=capacity[i]){
                additionalRocks-=capacity[i];
                capacity[i]=0;
                count++;
                }
                else return count;
               
            }else return count;
        }
        return capacity.length;
    }
}