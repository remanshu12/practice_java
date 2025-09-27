class Solution {
    public boolean canPlaceFlowers(int[] arr, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        int count = 1;
        for (int i=0;i<arr.length;i++) {
            if(arr[i]==0) {
                count++;
            }else{
                list.add(count);
                count=0;
            }
        }
        list.add(count+1); 
        System.out.println(list);
        for (int len:list) {
            n-=(len-1)/2;
            if(n<=0){return true;}
        }

        return n <= 0;
    }
}
