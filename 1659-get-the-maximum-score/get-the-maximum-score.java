class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums1.length;
        int m=nums2.length;
        for(int i=0;i<m;i++){
            map.put(nums2[i],i);
        }
        long mod=(long)1e9+7;
        long prefix1[]=new long[n];
        long prefix2[]=new long[m];
        prefix1[0]=nums1[0];
        for(int i=1;i<n;i++){
            prefix1[i]=prefix1[i-1]+nums1[i];
        }
         prefix2[0]=nums2[0];
        for(int i=1;i<m;i++){
            prefix2[i]=prefix2[i-1]+nums2[i];
        }
        long sum1=0;
        long sum2=0;
        long total=0;
        for(int i=0;i<n;i++){
            if(map.containsKey(nums1[i])){
                int index=map.get(nums1[i]);
                long temp1=prefix1[i]-sum1;
                long temp2=prefix2[index]-sum2;
                total+=Math.max(temp1,temp2);
                sum1+=temp1;
                sum2+=temp2;
            }
        }
         long temp1=prefix1[n-1]-sum1;
        long temp2=prefix2[m-1]-sum2;
         total+=Math.max(temp1,temp2);
       total=Math.max(total,prefix1[n-1]);
       total=Math.max(total,prefix2[m-1]);
       return (int)(total%mod);
    }
}