class Solution {
    public String arrangeWords(String text) {
        text=text.toLowerCase();
        String arr[]=text.split(" ");
        Arrays.sort(arr,(a,b)->a.length()-b.length());
        arr[0]=arr[0].substring(0,1).toUpperCase()+arr[0].substring(1);
        return String.join(" ",arr);

    }
}