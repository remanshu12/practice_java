class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int ll) {
        Queue<Integer> q=new LinkedList<>();
        int[] visited=new int[friends.length];
        q.add(id);
        visited[id]=1;
        int level=0;
        while(!q.isEmpty()){
            int size=q.size();
           
            for(int i=0;i<size;i++){
                int curr=q.poll();
                for(int ed:friends[curr]){
                    if(visited[ed]!=1){
                        visited[ed]=1;
                        q.add(ed);
                    }
                }
            }
             level++;
             if(level==ll){
                break;
             }
        }
        HashMap<String, Integer> map=new HashMap<>();
        while(!q.isEmpty()){
            int he=q.poll();
            for(String val:watchedVideos.get(he)){
            map.put(val,map.getOrDefault(val,0)+1);
            }

        }
        List<String> ans=new ArrayList<>(map.keySet());
        Collections.sort(ans,(a,b)->{
            if(!map.get(a).equals(map.get(b)))
            return map.get(a)-map.get(b);
            return a.compareTo(b);
        });
        return ans;
    }
}