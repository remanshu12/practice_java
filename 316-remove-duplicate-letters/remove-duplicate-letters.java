class Solution {
    public String removeDuplicateLetters(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        int visited[]=new int[26];
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.get(s.charAt(i))-1);
        if(visited[s.charAt(i)-'a']==1) continue;
            while(!st.isEmpty() && st.peek()>=s.charAt(i) && map.get(st.peek())>0){
               
                visited[st.peek()-'a']=0;
                st.pop();
            }
             
            st.push(s.charAt(i));
            visited[s.charAt(i)-'a']=1;

        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();

    }
}