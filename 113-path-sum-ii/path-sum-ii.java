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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
          find(root,targetSum,list,res);
          return list;
        
    }
    static void find(TreeNode root, int targetSum,List<List<Integer>> list,List<Integer> res){
        if(root==null  ){
            return ;
        }
       
        targetSum=targetSum-root.val;
        res.add(root.val);
         if(targetSum==0 && (root.left==null && root.right==null)){
            list.add(new ArrayList<>(res));
        }
        
        find(root.left,targetSum,list,res);
       find(root.right,targetSum,list,res);
         res.remove(res.size() - 1);

    }
}