class Solution {
    class pair{
        String first;
        int second;
        pair(String s,int sec){
            first=s;
            second=sec;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(beginWord,1));
        Set<String> set=new HashSet<>();
        for(String s:wordList){
            set.add(s);
        }
        set.remove(beginWord);
        while(!q.isEmpty()){
            pair p=q.poll();
            String s=p.first;
            int val=p.second;
            if(s.equals(endWord)){
                return val;
            }
            for(int i=0;i<s.length();i++){
                char replaceArr[]=s.toCharArray();
                for(char c='a';c<='z';c++){
                    replaceArr[i]=c;
                    String replace=new String(replaceArr);
                    if(set.contains(replace)){
                        set.remove(replace);
                        q.add(new pair(replace,val+1));
                    }
                }
            }
        }
        return 0;
    }
}