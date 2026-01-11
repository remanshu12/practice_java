class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k=(long)k1+k2;
        int n=nums1.length;
        long maxdiff=0;
        int dif=0;
        long max=0;
        int[] diff=new int[n];
        for(int i=0;i<n;i++){
            dif=Math.abs(nums1[i]-nums2[i]);
            diff[i]=dif;
            maxdiff+=dif;
            max=Math.max(dif,max);
        }
        if(maxdiff<=k){
            return 0;
        }
        int arr[]=new int[(int)max+1];
        for(int i=0;i<n;i++){
            arr[diff[i]]++;
        }
        for(int i=(int)max;i>=0 && k>0 ;i--){
            if(arr[i]==0){
                continue;
            }
            long count=(long)arr[i];
            if(k>=count){
                arr[i]=0;
                arr[i-1]+=count;
                k-=count;
            }else{
                arr[i]-=k;
                arr[i-1]+=k;
                k=0;
            }
        }
        long sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=((long)arr[i]*i*i);
        }
        return sum;
    }
}