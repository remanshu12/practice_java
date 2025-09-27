class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] in=new int[n+1];
        int[] out=new int[n+1];
        if (n==1&&trust.length==0) {
            return 1;
        }
        for(int i=0;i<trust.length;i++){
            in[trust[i][1]]++;
            out[trust[i][0]]++;
        }
        for(int i=0;i<=n;i++){
            if(in[i]==n-1 && out[i]==0){
                return i;
            }
        }
        return -1;
    }
}