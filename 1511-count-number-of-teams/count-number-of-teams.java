class Solution {
    public int numTeams(int[] rating) {
        int leftsmall=0;
        int rightlarge=0;
        int leftlarge=0;
        int rightsmall=0;
        int res=0;
        for(int i=1;i<rating.length-1;i++){
             leftsmall=0;
              rightlarge=0;
            leftlarge=0;
            rightsmall=0;
            int left=i-1;
            int right=i+1;
            while(left>=0){
            if(rating[left]<rating[i]){
                leftsmall++;
            }else if(rating[left]>rating[i]){
                leftlarge++;
            }
            left--; 
            }
            while(right<rating.length){
                if(rating[right]>rating[i]){
                    rightlarge++;
                }else if(rating[right]<rating[i]){
                    rightsmall++;
                }
                right++;
            }
            res+=rightsmall*leftlarge;
            res+=leftsmall*rightlarge;
        }

        return res;
    }
}