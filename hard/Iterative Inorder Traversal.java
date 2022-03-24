// https://www.algoexpert.io/questions/Iterative%20In-order%20Traversal
import java.util.function.Function;

/*
O(n) -- time
O(1) -- space
*/
class Program {
  public static void iterativeInOrderTraversal(
      BinaryTree tree, Function<BinaryTree, Void> callback) {

		BinaryTree node = null;

		while (tree != null || node != null) {
			while (tree != null) { // 9
				node = tree; // 9
				tree = tree.left; // null
			}
			callback.apply(node); // 9
			tree = node.right; // null
			if (tree == null) {
				while (node.parent != null && node.parent.left != node) {
					node = node.parent;
				}
				node = node.parent;
			}
		}
  }

  static class BinaryTree {
    public int value;
    public BinaryTree left;
    public BinaryTree right;
    public BinaryTree parent;

    public BinaryTree(int value) {
      this.value = value;
    }

    public BinaryTree(int value, BinaryTree parent) {
      this.value = value;
      this.parent = parent;
    }
  }
}
