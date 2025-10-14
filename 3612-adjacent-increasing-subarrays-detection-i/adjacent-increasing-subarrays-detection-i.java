class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        List<Integer> arr=new ArrayList<>();
        for(int i=0;i<2*k;i++){
            arr.add(nums.get(i));
        }
        if(check(arr,k)){
            return true;
        }
        for(int i=2*k;i<nums.size();i++){
            arr.remove(0);
            arr.add(nums.get(i));
            if(check(arr,1)){
                return true;
            }
        }
        return false;
    }
    static boolean check(List<Integer> arr,int k){
        for(int i=0;i<arr.size()-1;i++){
            if(arr.get(i)>=arr.get(i+1) ){
               if(i+1==arr.size()/2){
                k--;
               }else{
                return false;
               }
            
            }
           
        }
        return true;
    }
}