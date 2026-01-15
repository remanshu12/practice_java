class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hbars, int[] vbars) {
        Arrays.sort(hbars);
        Arrays.sort(vbars);
        int count=2;
        int ans=2;
        int count1=2;
        int ans1=2;
        for(int i=1;i<hbars.length;i++){
            if(hbars[i]-hbars[i-1]==1){
                count++;
            }else{
                count=2;

            }
            ans=Math.max(ans,count);
        }
        for(int i=1;i<vbars.length;i++){
        if(vbars[i]-vbars[i-1]==1){
                count1++;
            }else{
                count1=2;

            }
            ans1=Math.max(ans1,count1);}
       // System.out.println(ans+" "+ans1);
        ans=Math.min(ans,ans1);
        return ans*ans;
    }
}