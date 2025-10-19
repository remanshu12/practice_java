class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Queue<String> q = new LinkedList<>();
        Set<String> set=new HashSet<>();
        String small=s;
        set.add(s);
        q.add(s);
        while(!q.isEmpty()){
            String curr=q.poll();
            if(curr.compareTo(small)<0){
                small=curr;
            }
            //--------1st operation
            char[] arr=curr.toCharArray();
            for(int i=1;i<arr.length;i+=2){
                arr[i]=(char)((arr[i]-'0' +a)%10+'0');
            }
            String str=new String(arr);
            if(set.add(str)){
                q.add(str);
            }
            //--------2nd operation
            String rotated=curr.substring(curr.length()-b)+curr.substring(0,curr.length()-b);
            if(set.add(rotated)){
                q.add(rotated);
            }

        }
        return  small;
    }
}