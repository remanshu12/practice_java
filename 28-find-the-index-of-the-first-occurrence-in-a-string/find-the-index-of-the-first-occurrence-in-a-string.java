class Solution {
    public int strStr(String college, String clas) {
        if(clas.length()> college.length()){
            return -1;
        }
        for(int i=0;i<=college.length()-clas.length();i++){
            for(int j=0;j<clas.length();j++){
                if(college.charAt(i+j)!=clas.charAt(j)){
                    break;
                }
                if(j==clas.length()-1){
                    return i;
                }
            }
        }
        return -1;
       

    }
}