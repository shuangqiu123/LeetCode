// leetcode 297
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "n";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append(",");
        sb.append(serialize(root.left));
        sb.append(",");
        sb.append(serialize(root.right));
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodeValues = data.split(",");
        ArrayDeque<String> nodeValueList = new ArrayDeque<>();
        
        for (String value : nodeValues) {
            nodeValueList.addLast(value);
        }
        
        return recursivelyBuildTree(nodeValueList);
    }
    
    private TreeNode recursivelyBuildTree(ArrayDeque<String> nodeValueList) {
        if (nodeValueList.peekFirst().equals("n")) {
            nodeValueList.pollFirst();
            return null;
        }

        String value = nodeValueList.pollFirst();
        TreeNode node = new TreeNode(Integer.valueOf(value));
        node.left = recursivelyBuildTree(nodeValueList);
        node.right = recursivelyBuildTree(nodeValueList);
        
        return node;
    }
}