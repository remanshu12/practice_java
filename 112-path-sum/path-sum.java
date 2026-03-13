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
    static boolean helper(TreeNode root,int sum,int total){  
        if(root==null){   
            return false;
        }
        if(root.left==null && root.right==null && total+root.val==sum){
            return true;
        }
        return helper(root.left,sum,total+root.val) || helper(root.right,sum,total+root.val);
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        
        return helper(root,sum,0);
    }
}