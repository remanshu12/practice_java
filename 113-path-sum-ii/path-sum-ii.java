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
    static void helper(List<Integer> curr,List<List<Integer>> list,TreeNode root,int sum,int total){  
        if(root==null){   
            return;
        }
        if(root.left==null && root.right==null && total+root.val==sum){
            curr.add(root.val);
            list.add(new ArrayList<>(curr));
            curr.remove(curr.size()-1);
            return ;
        }
            curr.add(root.val);
         helper(curr,list,root.left,sum,total+root.val);
          helper(curr,list,root.right,sum,total+root.val);
          curr.remove(curr.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        helper(curr,list,root,sum,0);
        return list;

    }
}