class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int temp[]=new int[20001];
        int count=1;
        HashMap<Integer,Integer> map=new HashMap<>();
       
        for(int i=0;i<nums.length;i++){
            nums[i]+=10001;
        }
        System.out.println(Arrays.toString(nums));
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=nums.length-1;i>=0;i--){
            ans.add(rangesum(nums[i]-1,temp));
            update(temp,nums[i],1,20000);
        }
        Collections.reverse(ans);
        return ans;
    }
    static int rangesum(int i,int temp[]){
        int ans=0;
        for(;i>0;i-=(i&-i)){
            ans+=temp[i];
        }
        return ans;
    }
    static void update(int temp[],int i,int val,int n){
        for(;i<=n;i+=(i&-i)){
            temp[i]+=val;
        }
    }
}