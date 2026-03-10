class Solution {
    public int maxArea(int[] arr) {
        int left=0;
        int right=arr.length-1;
        int max=0;
        while(left<right){
            if(arr[left]<arr[right]){
                max=Math.max(max,(right-left)*Math.min(arr[left],arr[right]));
                left++;
            }else{
                 max=Math.max(max,(right-left)*Math.min(arr[left],arr[right]));
                 right--;
            }
        }
        return max;
    }
}