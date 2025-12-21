    class Solution {
        public int minDeletionSize(String[] strs) {
            int count=0;
            boolean flag=true;
            boolean issorted[]=new boolean[strs.length-1];
            for(int i=0;i<strs[0].length();i++){
                flag=true;
                for(int j=0;j<strs.length-1;j++){
                    if(!issorted[j] && strs[j].charAt(i)>strs[j+1].charAt(i)){
                        flag=false;
                        break;
                
                    }}
                if(flag==false){
                count++;
                continue;
            }
            for(int k=0;k<strs.length-1;k++){
                if(!issorted[k] && strs[k].charAt(i)<strs[k+1].charAt(i)){
                    issorted[k]=true;
                }
            }}
             return count;
            }
           
        
    }
    