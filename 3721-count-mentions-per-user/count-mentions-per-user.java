class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int mentions[]=new int[numberOfUsers];
        int offlinetime[]=new int[numberOfUsers];
        events.sort((a,b)->{
            int timea=Integer.parseInt(a.get(1));
            int timeb=Integer.parseInt(b.get(1));
            return timea==timeb?b.get(0).compareTo(a.get(0)):timea-timeb;
        });
        for(List<String> event:events){
            if(event.get(0).equals("MESSAGE")){
                handle(event,mentions,offlinetime);
            }else if(event.get(0).equals("OFFLINE")){
                handleoffline(event,offlinetime);
            }
        }
        return  mentions;
    }
    static void handle(List<String> event,int[] mentions,int[] offlinetime){
        int time=Integer.parseInt(event.get(1));
        String[] tokens=event.get(2).split(" ");
        for(String token:tokens){
            if(token.equals("ALL")){
                for(int i=0;i<mentions.length;i++){
                    mentions[i]++;
                }
            }else if(token.equals("HERE")){
                for(int i=0;i<mentions.length;i++){
                   if(offlinetime[i]==0 || offlinetime[i]+60<=time){
                    mentions[i]++;
                   }
                }
            }else{
                int id=Integer.parseInt(token.substring(2));
                mentions[id]++;
            }
        }
    }
    static void handleoffline(List<String> event,int[] offlinetime){
        int time=Integer.parseInt(event.get(1));
        int id=Integer.parseInt(event.get(2));
        offlinetime[id]=time;
    }
}