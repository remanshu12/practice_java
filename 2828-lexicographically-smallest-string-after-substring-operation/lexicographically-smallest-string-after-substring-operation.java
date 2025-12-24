class Solution {
    public String smallestString(String s) {
     //  boolean flag=true;
       int start=-1;
       int end=s.length();
       for(int i=0;i<s.length();i++){
        if(s.charAt(i)!='a' && start==-1){
            start=i;
            
        }else if(s.charAt(i)=='a' && start!=-1){
            end=i;
            break;
        }}
        
        int n=s.length();
        StringBuilder sb=new  StringBuilder();
        if(start==-1){
            return s.substring(0,n-1)+'z';
        }
         sb.append(s.substring(0,start));
         for(int i=start;i<end;i++){
            sb.append((char)(s.charAt(i)-1));
         }
         if(end!=-1)
         sb.append(s.substring(end));
         return sb.toString();
}
}