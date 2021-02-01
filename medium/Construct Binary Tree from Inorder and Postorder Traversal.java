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

    // memorize the position of the inorder array, since the tree does not have dups
    HashMap<Integer, Integer> map = new HashMap<>();
    int[] inorder;
    int[] postorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        
        for (int i=0;i<inorder.length;++i) {
            map.put(inorder[i],i);
        }
        
        return helper(0,inorder.length-1,postorder.length-1);
    }
    // inorder = [9,3,15,20,7]
    //            L r R
    // postorder = [9,15,7,20,3]
    //              L R       r
    public TreeNode helper(int start, int end, int pos) {
        if (start > end) return null;
        
        TreeNode root = new TreeNode(postorder[pos]);
        
        int rootIndex = map.get(root.val);
        root.left = helper(start,rootIndex-1, pos - end + rootIndex-1);
        root.right = helper(rootIndex+1,end,pos-1);
        return root;
    }
}