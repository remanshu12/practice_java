class Solution {
    public String removeSubstring(String s, int k) {
        Stack<Character> st=new Stack<>();
        char[] temp=s.toCharArray();
        for(int i=0;i<temp.length;i++){
                st.push(temp[i]);
            
           if(st.size()>=2*k){
               boolean balance=true;
               for(int j=0;j<k;j++){
                   if(st.get(st.size()-1-j)!=')'){
                        balance=false;
                       break;
                   }
               }
               for(int j=0;j<k && balance;j++){
                   if(st.get(st.size()-1-k-j)!='('){
                       balance=false;
                       break;
                   }
               }
               if(balance){
                   for(int l=0;l<2*k;l++){
                       st.pop();
                   }
               }
           }
        }
        StringBuilder sb=new StringBuilder();
        for(char c: st){
            sb.append(c);
        }
        return sb.toString();
    }
}