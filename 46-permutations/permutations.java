class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        helper(res,ans,nums,0);
        return res;
    }
    static void helper(List<List<Integer>> res,List<Integer> list,int[] nums,int i){
        if(i==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int index=i;index<nums.length;index++){
            swap(index,i,nums);
            list.add(nums[i]);
            helper(res,list,nums,i+1);
             swap(index,i,nums);
            list.remove(list.size()-1);
           
        }
    }
    static void swap(int i,int j,int[] arr){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}