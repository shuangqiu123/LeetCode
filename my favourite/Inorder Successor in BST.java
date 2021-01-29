/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // recursively find the successor
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        
        // if p is greater than or equal to root, it means the succesor is on the right
        if (root.val <= p.val) 
            return inorderSuccessor(root.right,p);

        // successor is either root or in the left
        else {
            TreeNode left = inorderSuccessor(root.left,p);
            return left!=null?left:root;
        }
    }

    // iterative
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode ptr = p;
        // if p has right child, then successor will be in the leftmost child of p
        if (p.right != null) {
            p = p.right;
            while (p.left != null) p = p.left;
            return p;
        }
        p = ptr;
        
        // inorder traversal
        Stack<TreeNode> stack = new Stack<>();
        boolean isFound = false;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            if (isFound) return root;
            if (root==p) isFound = true;
            root = root.right;
        } 
        
        return null;
    }


    //predescesor
    public TreeNode inorderPredescesor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        
        // if p is less than or equal to root, it means the predescesor is on the left
        if (root.val >= p.val) 
            return inorderSuccessor(root.left,p);

        // predescesor is either root or in the right
        else {
            TreeNode left = inorderSuccessor(root.right,p);
            return right!=null?right:root;
        } 
    }
}