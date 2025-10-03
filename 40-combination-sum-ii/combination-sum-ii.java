class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
          List<List<Integer>> res=new ArrayList<>();
          Arrays.sort(candidates);
        List<Integer> ans=new ArrayList<>();
        helper(res,ans,0,target,candidates);
        return res;
    }
    static void helper(List<List<Integer>> res,List<Integer> ans,int index,int target,int[] arr){
        if(target==0){
           res.add(new ArrayList<>(ans));
           return;
        }if(index==arr.length){
            return;
        }
        for(int i=index;i<arr.length;i++){
        if(i>index && arr[i]==arr[i-1]){
            continue;
        }
        if(target-arr[i]>=0){
            
         ans.add(arr[i]);
        helper(res,ans,i+1,target-arr[i],arr);
         ans.remove(ans.size()-1);
         }
        
    }}
}