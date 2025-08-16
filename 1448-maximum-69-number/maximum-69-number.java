class Solution {
    public int maximum69Number (int num) {
        ArrayList<Integer> arr=new ArrayList<>();
        while(num>0){
            arr.add(num%10);
            num=num/10;
        }
        for(int i=arr.size()-1;i>=0;i--){
            if(arr.get(i)==6){
                arr.set(i,9);
                break;
            }
        }
         for(int i=arr.size()-1;i>=0;i--){
            num=num*10+arr.get(i);
         }
         return num;
    }
}