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
    static void bst(ArrayList<Integer> arr,TreeNode root){
        if(root==null){
            return;
        }
        bst(arr,root.left);
        root.val=arr.remove(0);
        bst(arr,root.right);
    }
    public void recoverTree(TreeNode root) {
        ArrayList<Integer> arr=new ArrayList<>();
        inorder(arr,root);
        Collections.sort(arr);
        bst(arr,root);
    }
    static void inorder(ArrayList<Integer> arr, TreeNode root){
        if(root==null){
            return;
        }
        inorder(arr,root.left);
        arr.add(root.val);
        inorder(arr,root.right);
    }
}