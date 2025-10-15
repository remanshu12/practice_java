class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        List<Integer> list=new ArrayList<>();
        int n=nums.size();
        int count =1;
        list.add(count);
        for(int i=1;i<nums.size();i++){
            if(nums.get(i)>nums.get(i-1)){
                count++;
                list.add(count);
               
            }else{
                count=1;
                list.add(count);
            }
        }
        int low=1;
        int high=n/2;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(possible(mid,list,n)){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
    static boolean possible(int mid,List<Integer> nums,int n){
        for(int i=mid-1;i<n-mid;i++){
            if(nums.get(i)>=mid && nums.get(i+mid)>=mid){
                return true;
            }
        }
        return false;
    }
}