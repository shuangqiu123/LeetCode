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
    public int closestValue(TreeNode root, double target) {
        
        if (root.val == target) return root.val;
        int cmp = 0;
        
        if (root.val < target) {
            if (root.right == null) return root.val;
            
            cmp = closestValue(root.right,target);
        }
        else if (root.val > target) {
            if (root.left == null) return root.val;
            cmp = closestValue(root.left,target);
        }
        
        if (Math.abs(root.val - target) < Math.abs(cmp - target)) return root.val;
        
        return cmp;
         
    }
}