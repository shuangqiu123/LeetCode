// leetcode 98
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean isValidBST(TreeNode root, long lowerBound, long upperBound) {
        if (root == null) {
            return true;
        }
        long value = root.val;
        if (value < lowerBound || value > upperBound) {
            return false;
        }
        
        return isValidBST(root.left, lowerBound, value - 1) && isValidBST(root.right, value + 1, upperBound);
    }
}