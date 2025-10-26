class Bank {
        long[] bal;
        int n;
    public Bank(long[] balance) {
        bal=balance;
        n=balance.length;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        account1--;
        account2--;
        if(  account1<n && account2<n &&bal[account1]>=money){
            bal[account2]+=money;
            bal[account1]-=money;
            return true;
        }
        return false;
    }
    
    public boolean deposit(int account, long money) {
        account--;
        if(account<n){
        bal[account]+=money;
        return true;}
        return false;
    }
    
    public boolean withdraw(int account, long money) {
        account--;
        if(account<n){
        if(bal[account]>=money){
            bal[account]-=money;
            return true;
        }}
        return false;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */