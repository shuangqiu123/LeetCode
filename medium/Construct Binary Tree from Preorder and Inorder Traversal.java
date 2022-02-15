// leetcode 105
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, 0, inorder.length - 1);
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder, int preorderRootPosition, int inorderStart, int inorderEnd) {
        if (inorderEnd - inorderStart < 0) {
            return null;
        }
        int rootValue = preorder[preorderRootPosition];
        int inorderRootPosition = 0;
        for (int i = inorderStart; i <= inorderEnd; i++) {
            if (inorder[i] == rootValue) {
                inorderRootPosition = i;
                break;
            }
        }
        TreeNode node = new TreeNode(preorder[preorderRootPosition]);
        node.left = buildTree(preorder, inorder, preorderRootPosition + 1, inorderStart, inorderRootPosition - 1);
        node.right = buildTree(preorder, inorder, preorderRootPosition + (inorderRootPosition - inorderStart) + 1, inorderRootPosition + 1, inorderEnd);
        return node;
    }
}