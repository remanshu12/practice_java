class Solution {
    public int finalValueAfterOperations(String[] s) {
        int count=0;
        for(String st:s){
            if(st.equals("++X")||st.equals("X++")){
                count+=1;
            }else{
                count-=1;
            }
        }
        return count;
    }
}