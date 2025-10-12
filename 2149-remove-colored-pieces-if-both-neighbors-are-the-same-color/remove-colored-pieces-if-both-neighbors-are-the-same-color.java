class Solution {
    public boolean winnerOfGame(String colors) {
        int alice=0;
        int count_a=0;
        int count_b=0;
        int bob=0;
        for(int i=0;i<colors.length();i++){
           
             if(colors.charAt(i)=='A'){
                alice++;
                if(alice>=3){
                    count_a++;
                }
            }else {
                alice=0;
            }
            
             if(colors.charAt(i)=='B'){
                bob++;
                if(bob>=3){
                    count_b++;
                }
            }else {
                bob=0;
            }
            
        }
        
        
        if(count_a>count_b){
            return true;
        }
        return false;
    }
}