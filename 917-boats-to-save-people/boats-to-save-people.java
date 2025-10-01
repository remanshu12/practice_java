class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int lim[]=new int[limit+1];
        int i=1;
        int j=lim.length-1;
        int c=0;
        for(int wei : people) lim[wei]++;
        while(i<=j){
            if(lim[i]>0 && lim[j]>0 && i+j<=limit){
                lim[i]--;
                lim[j]--;
                c++;
            }else if(lim[j]>0){
                lim[j]--;
                c++;
            }
            while(i<=j && lim[i]<=0){
                i++;
            }
             while(i<=j && lim[j]<=0){
                j--;
            }
        }
        return c;
    }
}