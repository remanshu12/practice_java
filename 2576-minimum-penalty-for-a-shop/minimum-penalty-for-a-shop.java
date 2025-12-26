class Solution {
    public int bestClosingTime(String s) {
        int yes=0;
        int no=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='Y'){
                yes++;
            }else{
                no++;
            }
        }
        int yes1=0;
        int no1=0;
        int min=Integer.MAX_VALUE;
        int ind=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='Y'){
                yes1++;
            }else{
                no1++;
            }
            if(yes-yes1+no1<min){
                min=yes-yes1+no1;
                ind=i;
            }
        }
        if(yes<=min){
            return 0;
        }
        return ind+1;





    }
}