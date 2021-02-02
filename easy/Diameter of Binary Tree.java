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
    
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        
        helper(root);
        return max;
    }
    
    public int helper(TreeNode root) {
        if (root == null) return -1;
        int left = helper(root.left) + 1;
        int right = helper(root.right) + 1;
        
        max = Math.max(left+right, max);
        
        return Math.max(left,right);
    }
}