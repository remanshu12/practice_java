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
class BSTIterator {

    List<Integer> list=new ArrayList<>();
    public BSTIterator(TreeNode root) {
        inorder(list,root);
    }
    static void inorder(List<Integer> list,TreeNode root){
        if(root==null) return;
        inorder(list,root.left);
        list.add(root.val);
        inorder(list,root.right);

    }
    public int next() {
        return list.remove(0);
    }
    
    public boolean hasNext() {  
            if(list.size()>=1){
                return true;
            }
            return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */