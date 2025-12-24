class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int total=0;
        int count =0;
        for(int i:apple){
        total+=i;
        }
        Arrays.sort(capacity);
        for(int i=capacity.length-1;i>=0;i--){
            int val=capacity[i];
            total-=val;
            System.out.println(total);
            if(total>0){
                count++;
            }else{
                break;
            }
        }
        return count+1;
    }
}