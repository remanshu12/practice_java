class Solution {
    public String alphabetBoardPath(String target) {
        StringBuilder ans=new StringBuilder();
        int r=0;
        int c=0;
        for(char curr:target.toCharArray()){
            int val=curr-'a';
            int row=val/5;
            int col=val%5;

            while(r>row){
                ans.append('U');
                r--;
            }
            while(c>col){
                ans.append('L');
                c--;
            }
            while(r<row){
                ans.append('D');
                r++;
            }
            while(c<col){
                ans.append('R');
                c++;
            }
            ans.append('!');

        }
        return ans.toString();
    }
}