// leetcode 114
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        if (left == null) {
            flatten(right);
            return;
        }
        
        flatten(left);

        root.left = null;
        root.right = left;
        
        while (left.right != null) {
            left = left.right;
        }
        
        left.right = right;
        flatten(right);
    }
}