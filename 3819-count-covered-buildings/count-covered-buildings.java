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

        for (int[] v : arr) {
            int r = v[0];
            int c = v[1];

            minXforY[c] = (minXforY[c] == -1) ? r : Math.min(r, minXforY[c]);
            maxXforY[c] = (maxXforY[c] == -1) ? r : Math.max(r, maxXforY[c]);

            minYforX[r] = (minYforX[r] == -1) ? c : Math.min(c, minYforX[r]);
            maxYforX[r] = (maxYforX[r] == -1) ? c : Math.max(c, maxYforX[r]);
        }

        int ans = 0;

        for (int[] v : arr) {
            int r = v[0];
            int c = v[1];

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
