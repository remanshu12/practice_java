class Solution {
    public int countCoveredBuildings(int n, int[][] arr) {

        int[] minXforY = new int[n + 1];  
        int[] maxXforY = new int[n + 1];
        int[] minYforX = new int[n + 1];
        int[] maxYforX = new int[n + 1];

        // initialize arrays with -1
        for (int i = 0; i <= n; i++) {
            minXforY[i] = -1;
            maxXforY[i] = -1;
            minYforX[i] = -1;
            maxYforX[i] = -1;
        }

        // Fill min/max values
        for (int[] v : arr) {
            int r = v[0];
            int c = v[1];

            // For column c → track row range (up/down)
            if (minXforY[c] == -1) minXforY[c] = r;
            else minXforY[c] = Math.min(minXforY[c], r);

            if (maxXforY[c] == -1) maxXforY[c] = r;
            else maxXforY[c] = Math.max(maxXforY[c], r);

            // For row r → track column range (left/right)
            if (minYforX[r] == -1) minYforX[r] = c;
            else minYforX[r] = Math.min(minYforX[r], c);

            if (maxYforX[r] == -1) maxYforX[r] = c;
            else maxYforX[r] = Math.max(maxYforX[r], c);
        }

        int ans = 0;

        // Check for each building if it is covered
        for (int[] v : arr) {
            int r = v[0];
            int c = v[1];

            // Conditions:
            // min row in column < current row  → a building above
            // max row in column > current row  → a building below
            // min col in row < current col     → a building left
            // max col in row > current col     → a building right

            if (minXforY[c] < r &&
                maxXforY[c] > r &&
                minYforX[r] < c &&
                maxYforX[r] > c) {

                ans++;
            }
        }

        return ans;
    }
}
