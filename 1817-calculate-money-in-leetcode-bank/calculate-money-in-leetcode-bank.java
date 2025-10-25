class Solution {
    public int totalMoney(int n) {
        int i=0;
        int j=7;
        long total=0;
        while(n>=7){
            n=n-7;
        total+=(j*(j+1))/2;
        total-=(i*(i+1))/2;
       // System.out.println(total);
        j++;
        i++;
        }
        n=n+i;
        total+=(n*(n+1))/2;
        total-=(i*(i+1))/2;
        return (int)total;
    }
}