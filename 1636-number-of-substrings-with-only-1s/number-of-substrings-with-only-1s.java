class Solution {
    public int numSub(String s) {
        long total=0;
        long one=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                one++;
            }else {
                total+=((one*(one+1))/2)%(long)1000000007;   
                one=0; 
            }    
        } 
        total+=((one*(one+1))/2)%(long)1000000007;   
        return (int)total;
    }
}