class Solution {
    public boolean exist(char[][] board, String word) {
        
        int row=board.length;
        int col=board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(helper(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    static boolean helper(char[][] arr,String word,int i,int j,int index){
        if(index==word.length()){
            return true;
        }
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j]!=word.charAt(index)){
            return false;
        }
        char temp=arr[i][j];
        arr[i][j]='#';
            boolean flag= helper(arr,word,i-1,j,index+1)
             || helper(arr,word,i,j+1,index+1)
             || helper(arr,word,i+1,j,index+1) 
             || helper(arr,word,i,j-1,index+1);
        arr[i][j]=temp;

        return flag;
    }
}