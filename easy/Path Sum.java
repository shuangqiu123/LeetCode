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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return hasPathSum(root, targetSum,0);
    }
    public boolean hasPathSum(TreeNode root, int targetSum, int acc) {
        if (root == null) return false;
        if (acc+root.val == targetSum && root.left == null && root.right == null) return true;
        
        return hasPathSum(root.left, targetSum, acc+root.val) || hasPathSum(root.right, targetSum, acc+root.val);
    }
    
}