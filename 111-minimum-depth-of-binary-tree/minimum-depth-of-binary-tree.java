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
  
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
          int arr[]=new int[1];
          arr[0]=Integer.MAX_VALUE;
          helper(root,arr,1);
          return arr[0];
        
    }
    static void helper(TreeNode root,int arr[],int level){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            arr[0]=Math.min(arr[0],level);
        }
        helper(root.left,arr,level+1);
        helper(root.right,arr,level+1);
        
    }
}