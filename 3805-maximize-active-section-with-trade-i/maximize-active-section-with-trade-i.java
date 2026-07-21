class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        ArrayList<Integer> list=new ArrayList<>();
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                count++;
            }else{
                if(count!=0)
                list.add(count);
                count=0;
            }
        }
        if(count!=0){
            list.add(count);
        }
        int one=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                one++;
            }
        }
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        if(list.size()<2) return one;
        int max=0;
        for(int i=1;i<list.size();i++){
            max=Math.max(max,list.get(i)+list.get(i-1));
        }
        return max+one;
    }
}