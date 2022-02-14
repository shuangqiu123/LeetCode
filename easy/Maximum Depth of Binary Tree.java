// leetcode 104
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        return maxDepth;
    }
}