class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int arr[]=new int[spells.length];
        Arrays.sort(potions);
        int n=spells.length;
        for(int i=0;i<n;i++){
            arr[i]=binary(spells[i],potions,success);
        }
        return arr;
    }
    static int binary(int val,int arr[],long target){
        int start=0;
        int end=arr.length-1;
        int ans=arr.length;
        
        while(start<=end){
            int mid=start+(end-start)/2;
            long product=(long)arr[mid]*(long) val;
            if(product>=target){
                ans=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
       
        return arr.length-ans;
    }
}