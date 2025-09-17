class Solution {
    public int[] sumZero(int n) {
        int arr[] = new int[n];
        int val=1;
        for (int i=0;i<n/2;i++) {
            arr[i]=val;
            arr[n-i-1]=-val;
            val++;
        }
        if (n%2 == 1) {
            arr[n/2]=0;
        }
        
        return arr;
    }
}
