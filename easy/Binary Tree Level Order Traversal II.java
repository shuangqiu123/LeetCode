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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();
        ArrayDeque<List<Integer>> deque = new ArrayDeque<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
             Queue<TreeNode> tmp = new ArrayDeque<>();
            ArrayList<Integer> list = new ArrayList<>();
             while (!queue.isEmpty()) {
                 root = queue.poll();
                 list.add(root.val);
                 if (root.left!=null) tmp.add(root.left);
                 if (root.right!=null) tmp.add(root.right);
             }
            deque.addFirst(list);
            queue = tmp;
        }
        
        return new ArrayList<>(deque);
    }
}