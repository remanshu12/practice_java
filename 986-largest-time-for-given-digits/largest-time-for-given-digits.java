class Solution {
    String ans="";
    public String largestTimeFromDigits(int[] arr) {
        boolean[] visit=new boolean[4];
        int[] temp=new int[4];
        dfs(arr,temp,visit,0);
        return ans;
    }
    void dfs(int[] arr, int[] temp,boolean[] visit,int index){
        if(index==4){
            int h=temp[0]*10+temp[1];
            int m=temp[2]*10+temp[3];
            if(h<24 && m<60){
                String time=(h<10?"0":"")+h+":"+(m<10?"0":"")+m;
                if(ans.equals("") || time.compareTo(ans)>0){
                    ans=time;
                }
            }
            return;
        }
        for(int i=0;i<4;i++){
            if(visit[i]){
                continue;
            }
            visit[i]=true;
            temp[index]=arr[i];
            dfs(arr,temp,visit,index+1);
            visit[i]=false;
        }
    }

}