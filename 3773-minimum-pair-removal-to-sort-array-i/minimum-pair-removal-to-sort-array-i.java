class Solution {
    public int minimumPairRemoval(int[] nums) {
        ArrayList<Long>list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add((long)nums[i]);
        }
        int steps=0;
        while(true){
            boolean check=true;
            for(int i=0;i<list.size()-1;i++){
                if(list.get(i)>list.get(i+1)){
                    check=false;
                    break;
                }
            }
            if(check){
                return steps;
            }
           // System.out.println("rr");
            steps++;
            long minsum=Integer.MAX_VALUE;
            int minind=0;
            for(int i=0;i<list.size()-1;i++){
                long sum=list.get(i)+list.get(i+1);
                if(sum<minsum){
                    minsum=sum;
                    minind=i;
                }
            }
            list.set(minind,minsum);
            list.remove(minind+1);

        }
    }
}