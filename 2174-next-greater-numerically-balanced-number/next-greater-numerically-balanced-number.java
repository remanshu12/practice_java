class Solution {
    public int nextBeautifulNumber(int n) {
        while(true){
            n++;
            if(check(n)){
                return n;
            }
            
        }
    }
    static boolean check(int n){
        HashMap<Integer,Integer> map=new HashMap<>();
        while(n>0){
            int r=n%10;
            map.put(r,map.getOrDefault(r,0)+1);
            n=n/10;
        }

        for(int i : map.keySet()){
            if(i!=map.get(i)){
                return false;
            }
        }
        return true;
    }
}