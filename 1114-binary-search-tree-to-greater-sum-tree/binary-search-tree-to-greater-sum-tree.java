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
    static int i =0;
    public TreeNode bstToGst(TreeNode root) {
        ArrayList<Integer> arr=new ArrayList<>();
        
        find(arr,root);
        for(int i=arr.size()-1;i>0;i--){
            arr.set(i-1, arr.get(i) + arr.get(i-1));
        }
        i=0;
       return change(arr,root);
    }
    static void find(ArrayList<Integer> arr,TreeNode root){
        if(root==null){
            return;
        }
        find(arr,root.left);
        arr.add(root.val);
        find(arr,root.right);


    }
    static TreeNode change(ArrayList<Integer> arr,TreeNode root){
        if(root==null){
            return root;
        }
        change(arr,root.left);
        root.val=arr.get(i++);
        change(arr,root.right);
        return root;

    }
}