class Solution {
    public int distMoney(int money, int children) {
        if(children>money){
            return -1;
        }
        money-=children;
        int val=money/7;
        int rem=money%7;
        if(val>children){
            return children-1;
        }else if(val==children-1 && rem==3){
            return children-2;
        }else if(val==children && rem!=0){
            return children-1;
        }
        else{
            return val;
        }

    }
}