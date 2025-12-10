class Solution {
    public int countPermutations(int[] arr) {
     for(int i=1;i<arr.length;i++){
        if(arr[i]<=arr[0]){
            return 0;
        }
     }
        
        long sum=1;
        long n=arr.length-1;
        while(n>0){
            sum*=n;
            n--;
            sum=sum%1_000_000_007;
        }
        return (int)sum;
    }
}