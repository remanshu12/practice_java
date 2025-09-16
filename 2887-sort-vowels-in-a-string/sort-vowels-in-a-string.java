class Solution {
    public String sortVowels(String s) {
        PriorityQueue<Character> pq=new PriorityQueue<>();
        for(char c: s.toCharArray()){
            if(isVowel(c)){
                pq.add(c);
            }
        }
        StringBuilder result=new StringBuilder();
        for(char c: s.toCharArray()){
            if(isVowel(c)){
                result.append(pq.poll());
            }else{
                result.append(c);
            }
        }
        return result.toString();
    }
    static boolean isVowel(char c){
        return "AEIOUaeiou".indexOf(c)!= -1;
    }
}