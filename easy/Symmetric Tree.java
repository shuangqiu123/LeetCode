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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode[]> stack = new Stack<>();
        stack.add(new TreeNode[]{root.left,root.right});
        
        while (!stack.isEmpty()) {
            TreeNode[] list = stack.pop();
            TreeNode left = list[0], right = list[1];
            
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            
            stack.add(new TreeNode[]{left.left,right.right});
            stack.add(new TreeNode[]{left.right,right.left});
        }
        
        return true;
    }
    
    public boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return isSame(left.left,right.right) && isSame(left.right,right.left);
    }
}