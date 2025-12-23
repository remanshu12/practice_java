class Solution {
    public String generateTag(String str) {
       if(str==null || str.trim().length()==0 ){
        return "#";
       }
       String arr[]=str.trim().split("\\s+");
       StringBuilder sb=new StringBuilder("#");
       sb.append(arr[0].toLowerCase());
        for(int i=1;i<arr.length;i++){
            sb.append(arr[i].substring(0,1).toUpperCase());
            sb.append(arr[i].substring(1).toLowerCase());
            if(sb.length()>=100){
                break;
            }
        }
        String ans=sb.toString();
        if(ans.length()>=100){
            return ans.substring(0,100);
        }
        return ans;
    }
}