class Solution {
    public int maxBottlesDrunk(int full, int ex) {
       int total=full;
        //count=0;
        while(true){
            if(full>=ex){
                total++;
                
            }else{
                return total;
            }
            full=full-ex;
            ex++;
            full++;
            
            
            

        }
        //return 0;
    }
}