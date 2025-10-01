class Solution {
    public int candy(int[] ratings) {
        int arr[]=new int[ratings.length];
        arr[0]=1;
        int candy=1;
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                candy++;
                arr[i]=candy;
            }else{
                candy=1;
                arr[i]=candy;
            }
        }
        candy=1;
        arr[arr.length-1]=Math.max(arr[arr.length-1],candy);
        for(int i=ratings.length-1;i>0;i--){
            if(ratings[i]<ratings[i-1]){
                candy++;
                arr[i-1]=Math.max(arr[i-1],candy);
            }else{
                candy=1;
                arr[i-1]=Math.max(arr[i-1],candy);
                
            }
        }
        
        int total=0;
        for(int i:arr){
            total+=i;
        }
        return total;
    }
}