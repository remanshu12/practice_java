class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)-> b-a);
        int sum=0;
        for(int i=0;i<target.length;i++){
            sum+=target[i];
            pq.add(target[i]);
        }
        int maxele=0;
        int remsum=0;
        int ele=0;
        while(pq.peek()!=1){
            maxele=pq.poll();
            remsum=sum-maxele;
            if(remsum<=0 || remsum>=maxele){
                return false;
            }
            ele=maxele%remsum;
            if(ele==0){
                if(remsum==1){
                    return true;
                }else{
                    return false;
                }
            }
            sum=remsum+ele;
            pq.add(ele);
            
        }
        return true;
    }
}