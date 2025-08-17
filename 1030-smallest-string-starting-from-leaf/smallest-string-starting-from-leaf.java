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
    String small=null;
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder s=new StringBuilder();
        dfs(root,s);
        return small;
    }
    private void dfs(TreeNode root,StringBuilder s){
        if(root==null){
            return;
        }
        s.append((char)('a'+root.val));
        if(root.left==null && root.right==null){
            String st=s.reverse().toString();
            s.reverse();

        if(small==null || st.compareTo(small)<0){
            small=st;
        }

        }
        dfs(root.left,s);
        dfs(root.right,s);
        s.deleteCharAt(s.length()-1);
    }
}