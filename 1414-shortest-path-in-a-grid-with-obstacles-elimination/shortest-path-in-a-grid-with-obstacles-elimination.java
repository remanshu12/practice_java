class Solution {
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        
        // Edge case: Agar start hi target hai
        if (n == 1 && m == 1) return 0;
        
        // dist[][] ki jagah maxK[][] array: Ye track karega ki cell pe maximum kitna k bacha hai
        int maxK[][] = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                maxK[i][j] = -1; // Shuru mein sab empty
            }
        }
        
        maxK[0][0] = k;
        Queue<int[]> q = new LinkedList<>();
        // q mein daalenge: {row, col, remaining_k, steps_taken}
        q.add(new int[]{0, 0, k, 0});
        
        int rowAr[] = {-1, 0, 1, 0};
        int colAr[] = {0, 1, 0, -1};
        
        while(!q.isEmpty()){
            int row = q.peek()[0];
            int col = q.peek()[1];
            int restK = q.peek()[2]; // Kitne obstacles todne ki power bachi hai
            int dis = q.peek()[3];   // Kitne steps chale hain
            q.poll();
            
            // Kyunki BFS hai, jo sabse pehle (n-1, m-1) par aayega, wahi shortest path hoga
            if (row == n - 1 && col == m - 1) {
                return dis;
            }
            
            for(int i = 0; i < 4; i++){
                int newrow = rowAr[i] + row;
                int newcol = colAr[i] + col;
                
                if(newrow >= 0 && newrow < n && newcol >= 0 && newcol < m){
                    // Naye cell par jane ke baad kitni power bachegi?
                    int newRestK = restK - grid[newrow][newcol];
                    
                    // 1. Agar power negative nahi hai (matlab rasta valid hai)
                    // 2. Agar ye rasta is cell par pehle se BEHTAR power le kar aaya hai
                    if(newRestK >= 0 && newRestK > maxK[newrow][newcol]){
                        maxK[newrow][newcol] = newRestK; // Record update kar do
                        q.add(new int[]{newrow, newcol, newRestK, dis + 1});
                    }
                }
            }
        }
        
        return -1; // Agar queue khali ho gayi aur target nahi mila
    }
}