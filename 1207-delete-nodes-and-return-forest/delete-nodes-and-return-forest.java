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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        ArrayList<TreeNode> arr=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();
        for(int i:to_delete){
            set.add(i);
        }
        find(set,arr,root,true);
        return arr;
    }
    static TreeNode find(HashSet<Integer> set,ArrayList<TreeNode> arr,TreeNode root, boolean isRoot ){
        if(root==null){
            return null;
        }
        boolean deleted=set.contains(root.val);
        if(isRoot && !deleted){
            arr.add(root);
        }
        root.left=find(set,arr,root.left,deleted);
        root.right=find(set,arr,root.right,deleted);
        return deleted? null:root;
    }
}