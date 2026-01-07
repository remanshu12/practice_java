class Solution {
    public List<Integer> goodDaysToRobBank(int[] arr, int time) {
        List<Integer>list = new ArrayList<>();
        int n=arr.length;
        if(time==0){
            for(int i=0;i<n;i++){
                list.add(i);
            }
            return list;
        }
        int suff[]=new int[n];
        for(int i=n-2;i>=0;i--){
            if(arr[i]<=arr[i+1]){
                suff[i]=suff[i+1]+1;
            }
        }
        int curr=0;
        for(int i=1;i<n;i++){
            if(arr[i]<=arr[i-1]){
                curr++;
            }else{
                curr=0;
            }
            if( i>=time && i<n-time &&  curr>=time && suff[i]>=time){
                list.add(i);
            }
        }
        return list;
    }
}