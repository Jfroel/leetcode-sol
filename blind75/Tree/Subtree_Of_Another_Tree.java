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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        return match(root, subRoot) 
                || isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot);
    
        
    }
    
    private boolean match(TreeNode root, TreeNode subRoot) {
         if (root == null && subRoot == null) return true;
         if (root == null || subRoot == null) return false;
        
        
        return root.val == subRoot.val
                && match(root.left, subRoot.left) 
                && match(root.right, subRoot.right); 
    }
}
