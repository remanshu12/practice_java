class Solution {
    public String resultingString(String s) {
        Stack<Character> stack=new Stack<>();
int i=0;
        while(i<s.length()){
            while(i<s.length() && !stack.isEmpty() && (Math.abs(s.charAt(i)-stack.peek())==25 || Math.abs(s.charAt(i)-stack.peek())==1)){
              
                stack.pop();
                  i++;
            }
            if(i<s.length()){
            stack.push(s.charAt(i));
            i++;}
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}