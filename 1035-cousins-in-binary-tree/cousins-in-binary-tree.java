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

import java.util.*;

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean foundX = false;
            boolean foundY = false;
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                
                // Check children for being x and y to detect same parent
                if (node.left != null && node.right != null) {
                    if ((node.left.val == x && node.right.val == y) ||
                        (node.left.val == y && node.right.val == x)) {
                        return false; // siblings → not cousins
                    }
                }
                
                if (node.val == x) foundX = true;
                if (node.val == y) foundY = true;
                
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            
            // After finishing this level
            if (foundX && foundY) return true;  // same level, different parent
            if (foundX || foundY) return false; // one found on this level → not cousins
        }
        
        return false; // not found
    }
}
