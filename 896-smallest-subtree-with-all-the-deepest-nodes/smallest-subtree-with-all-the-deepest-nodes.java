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
    HashMap<Integer,Integer> map=new HashMap<>();
    int maxd=0;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        depth(root,0);
       return lca(root);
    }
    TreeNode lca(TreeNode root){
        if(root==null || map.get(root.val)==maxd){
            return root;
        }
        TreeNode left=lca(root.left);
        TreeNode right=lca(root.right);
        if(left!=null && right!=null){
            return root;
        }
        if(left!=null){
            return left;
        }
        return right;
    }
     void depth(TreeNode root,int d){
        if(root==null){
            return;
        }
        map.put(root.val,map.getOrDefault(root.val,0)+d);
        maxd=Math.max(maxd,d);
        depth(root.left,d+1);
        depth(root.right,d+1);
    }
}