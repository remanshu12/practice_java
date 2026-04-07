class Solution {
    public int mirrorFrequency(String s) {
        ArrayList<Character> visited=new ArrayList<>();
        int arr[]=new int[256];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)]++;
        }
        int sum=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            char mirror='a';
           if(Character.isLetter(c)){
             mirror=(char)('z'-(c-'a'));
           }else{
             mirror=(char)('0'+('9'-c));
           }
         //  System.out.println(c);
           // System.out.println(mirror);
           if(visited.contains(c)) continue;
           if(!visited.contains(c)){
            sum+=Math.abs(arr[c]-arr[mirror]);
           }
           visited.add(c);
           visited.add(mirror);
        }
        return sum;
    }
}