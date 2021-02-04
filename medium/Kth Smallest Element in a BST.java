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
 // recursive
class Solution {
    int num = 0;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return num;
    }
    
    public void helper(TreeNode root) {
        if (root.left != null)
            helper(root.left);
        
        count--;
        
        if (count == 0) {
            num = root.val;
            return;
        }
        
        if (root.right != null)
            helper(root.right);
    }
}

//iterative
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            if (k == 1) return root.val;
            k--;
            root = root.right;  
        }
        return -1;
    }

}