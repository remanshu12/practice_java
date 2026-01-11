class Solution {
    public int maximalRectangle(char[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int psum[][]=new int[n][m];
        for(int j=0;j<m;j++){
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=arr[i][j]-'0';
                if(arr[i][j]=='0'){
                    sum=0;
                }
                psum[i][j]=sum;
            }
        }
        int max=0;
        for(int k=0;k<n;k++){
            max=Math.max(max,area(psum[k]));
        }
        return max;
    }
    public int area(int[] arr){
        int n=arr.length;
        int max=0;
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                int ele=arr[stack.peek()];
                stack.pop();
                int nse=i;
                int pse=stack.isEmpty()? -1:stack.peek();
                max=Math.max(max,ele*(nse-pse-1));
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
             int ele=arr[stack.peek()];
                stack.pop();
                int nse=n;
                int pse=stack.isEmpty()? -1:stack.peek();
                max=Math.max(max,ele*(nse-pse-1));
        }
        return max;
    }

}