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
    public int amountOfTime(TreeNode root, int start) {
      if(root==null){
        return 0;
      }  

      int time=0;

      HashMap<TreeNode,TreeNode> parentmap=new HashMap<>();
      find(parentmap,root);

      Queue<TreeNode> q=new LinkedList<>();

      HashSet<TreeNode> visited=new HashSet<>();

      TreeNode tree=findNode(root,start);
            q.add(tree);

    while(!q.isEmpty()){
        int size=q.size();
        for(int i=0;i<size;i++){
            TreeNode curr=q.poll();
            visited.add(curr);

            if(parentmap.containsKey(curr) && !visited.contains(parentmap.get(curr))){
                q.add(parentmap.get(curr));
            }
            if(curr.left!=null && !visited.contains(curr.left)){
                q.add(curr.left);
            }
            if(curr.right!=null && !visited.contains(curr.right)){
                q.add(curr.right);
            }
        }
        time++;
    }
    return time-1;
    }
    static void find(HashMap<TreeNode,TreeNode> parentmap,TreeNode root){
        if(root==null){
            return;
        }
        if(root.left!=null){
            parentmap.put(root.left,root);
        }
        if(root.right!=null){
            parentmap.put(root.right,root);
        }
        find(parentmap,root.left);
        find(parentmap,root.right);
        
    }
    static TreeNode findNode(TreeNode root, int start){
         if (root == null) return null;
    if (root.val == start) return root;
    TreeNode left = findNode(root.left, start);
    if (left != null) return left;
    return findNode(root.right, start);
    }
}