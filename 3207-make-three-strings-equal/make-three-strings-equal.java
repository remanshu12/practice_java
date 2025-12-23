class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int count=0;
        int n=Math.min(s1.length(),s2.length());
        n=Math.min(n,s3.length());
        for(int i=0;i<n;i++){
            if(s1.charAt(i)==s2.charAt(i) && s2.charAt(i)==s3.charAt(i)){
                count++;
            }else{
               
                break;
            }
        }
        if(count==0){
            return -1;
        }
       // System.out.println(temp);
        return s1.length()+s2.length()+s3.length()-3*count;
    }
}