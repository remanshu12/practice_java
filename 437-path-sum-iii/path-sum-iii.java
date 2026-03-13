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
    private int ans=0;
    public int pathSum(TreeNode root, int target) {
      
        if(root==null) return 0;
        helper(root,target);
        pathSum(root.left,target);
        pathSum(root.right,target);
        return ans;

    }
    public void  helper(TreeNode root,long sum){
       
        if(root==null) return;
        if(sum==root.val) ans++;
        sum-=root.val;
        helper(root.left,sum);
        helper(root.right,sum);
    }
}