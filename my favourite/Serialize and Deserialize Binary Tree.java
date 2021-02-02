/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }

 inorder traversal
 construct a complete tree, mark null node "X"
 decode the string
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "X";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(",");
        sb.append(serialize(root.left)).append(",");
        sb.append(serialize(root.right));
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserialize(new ArrayDeque<String>(Arrays.asList(data.split(","))));
    }
    
    public TreeNode deserialize(ArrayDeque<String> data) {
        String s = data.pollFirst();
        if (s.equals("X") ) return null;
        TreeNode node = new TreeNode();
        
        node.val = Integer.parseInt(s);
        node.left = deserialize(data);
        node.right = deserialize(data);
        
        
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));