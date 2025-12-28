class Solution{
    public long maximumSubsequenceCount(String text,String pattern){
        char x=pattern.charAt(0);
        char y=pattern.charAt(1);
        long cx=0;
        long cy=0;
        long base=0;
        for(int i=0;i<text.length();i++){
            char c=text.charAt(i);
            if(c==y){   
                base+=cx;
            }
            if(c==x){
                cx++;
            } 
            if(c==y){
                cy++;
            }
        }
        if(x==y){
            long n=cx+1;
            return n*(n-1)/2;
        }
        return base+Math.max(cx,cy);
    }
}