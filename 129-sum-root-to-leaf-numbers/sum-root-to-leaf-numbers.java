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
    public int sumNumbers(TreeNode root) {
        ArrayList<Integer> arr=new ArrayList<>();
       helper(root,0,arr); 
       int sum=0;
       for(int i:arr){
        sum+=i;
       }
       return sum;
    }
    static void helper(TreeNode root,int sum,ArrayList<Integer> arr){
        if(root==null){
            return;
        }
        sum=sum*10+root.val;

        if(root.left==null && root.right==null){
            arr.add(sum);
        }
        
        helper(root.left,sum,arr);
        helper(root.right,sum,arr);
        
    }
}