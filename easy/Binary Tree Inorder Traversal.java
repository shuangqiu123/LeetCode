class Solution {
    // recursively
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        traverse(list, root);
        return list;
    }
    
    private void traverse(ArrayList<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(list, root.left);
        list.add(root.val);
        traverse(list, root.right);
    }

    // iteratively
        public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        TreeNode node = root;
        
        while (!deque.isEmpty() || node != null) {
            while (node != null) {
                deque.add(node);
                node = node.left;
            }
            node = deque.pollLast();
            list.add(node.val);
            node = node.right;
        }
        
        return list;
    }
}