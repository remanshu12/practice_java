class Solution {
    public int intersectionSizeTwo(int[][] arr) {
        // Correct sorting
        Arrays.sort(arr, (a, b) ->
            a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]
        );

        int count = 2;
        int min = arr[0][1];     // last chosen number
        int max = min - 1;       // second last chosen

        for(int i = 1; i < arr.length; i++) {

            boolean c1 = min >= arr[i][0] && min <= arr[i][1];  // last number inside interval?
            boolean c2 = max >= arr[i][0] && max <= arr[i][1];  // second last number inside?

            if(c1 && c2) {
                // Already 2 numbers inside → NO NEED TO ADD
                continue;
            }
            else if(c1) {
                // Only one number inside → add 1 more
                max = min;
                min = arr[i][1];
                count++;
            }
            else {
                // No number inside → add 2 numbers
                max = arr[i][1] - 1;
                min = arr[i][1];
                count += 2;
            }
        }
        return count;
    }
}
