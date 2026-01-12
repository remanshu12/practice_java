class Solution {
    public int minimumOperations(int[] nums) {
        HashMap<Integer,Integer> even=new HashMap<>();
         HashMap<Integer,Integer> odd=new HashMap<>();
         for(int i=0;i<nums.length;i++){
            if(i%2==0){
                even.put(nums[i],even.getOrDefault(nums[i],0)+1);
            }else{
                odd.put(nums[i],odd.getOrDefault(nums[i],0)+1);
            }
         }
        int maxKey=-1,smaxKey = -1;
        int maxCount=0,smaxCount = 0;
for (int key:even.keySet()) {
    int count=even.get(key);
    if (count>maxCount) {
        smaxCount=maxCount;
        smaxKey=maxKey;
        maxCount=count;
        maxKey=key;
    } 
    else if(count>=smaxCount && count<=maxCount) {
        smaxCount=count;
        smaxKey=key;
    }
}

         // for odd
         int maxKey1=-1,smaxKey1 = -1;
        int maxCount1=0,smaxCount1 = 0;
for (int key:odd.keySet()) {
    int count=odd.get(key);
    if (count>maxCount1) {
        smaxCount1=maxCount1;
        smaxKey1=maxKey1;
        maxCount1=count;
        maxKey1=key;
    } 
    else if(count>=smaxCount1 && count<=maxCount1) {
        smaxCount1=count;
        smaxKey1=key;
    }
}           
            System.out.println(smaxKey+" "+smaxKey1);
           System.out.println(smaxCount+" "+smaxCount1);
         if(maxKey!=maxKey1){  
            return nums.length-(maxCount+maxCount1);
         }
        
            return Math.min((nums.length-(maxCount+smaxCount1)),(nums.length-(maxCount1+smaxCount)));
         


    }
}