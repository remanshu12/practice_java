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
    static void helper(TreeNode root,ArrayList<Integer> list){
        if(root==null) return ;
        helper(root.left,list);
        list.add(root.val);
        helper(root.right,list);

        
    }
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<>();
        helper(root,list);
        return isvalidate(list);
    }
    static boolean isvalidate(ArrayList<Integer> list){
            for(int i=0;i<list.size()-1;i++){
                if(list.get(i)>=list.get(i+1)){
                    return false;
                }
            }
            return true;
    }
}