class Solution {
    public boolean uniformArray(int[] nums1) {
        int min=Integer.MAX_VALUE;
        for(int i:nums1){
            if(i%2!=0)
            min=Math.min(min,i);
        }
        int even=0;
        int odd=0;
        for(int i:nums1){
            if(i%2==0) even++;
            else odd++;
        }
        if(even==0 || odd==0) return true;
        for(int i:nums1){
            if(i%2==0){
                if(i-min<1) return false;
            }
        }
        return true;

    }
}