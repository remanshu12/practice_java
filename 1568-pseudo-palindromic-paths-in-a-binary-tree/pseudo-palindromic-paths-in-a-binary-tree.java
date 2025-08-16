/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
   static int count=0;
    public int pseudoPalindromicPaths (TreeNode root) {
        int arr[]=new int[10];
        count=0;
          dfs(arr,root);

          return count;
    }
    static void dfs(int[] arr,TreeNode root){
        if(root==null){
            return;
        }
        arr[root.val]++;

        if(root.left==null && root.right==null){
            int oddcount=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2!=0){
                oddcount++;
            }
        }
        if(oddcount<=1){
            count++;
        }

        }
        dfs(arr,root.left);
        dfs(arr,root.right);
        arr[root.val]--;
        
    }
   
}