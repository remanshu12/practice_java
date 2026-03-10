class Solution {
    public int compress(char[] chars) {
        StringBuilder sb=new StringBuilder();
        char prev=chars[0];
        int count=0;
        for(char c:chars){
            if(c==prev){
                count++;
            }else{
                sb.append(prev);
                if(count>1)
                sb.append(count);
                count=1;
                prev=c;
            }

        }
        sb.append(prev);
         if(count>1)
         sb.append(count);
         String s=sb.toString();

         for(int i=0;i<s.length();i++){
            chars[i]=s.charAt(i);
         }
       
        return s.length();
    }
}