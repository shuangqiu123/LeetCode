// https://www.algoexpert.io/questions/Flatten%20Binary%20Tree
/*
O(n) time and space complexity
*/
import java.util.*;

class Program {
  public static BinaryTree flattenBinaryTree(BinaryTree root) {
    return helper(root)[0];
  }

  public static BinaryTree[] helper(BinaryTree root) {
    if (root == null) {
			return null;
		}
		BinaryTree[] left = helper(root.left);
		BinaryTree[] right = helper(root.right);
		
		if (right != null) {
			right[0].left = root;
			root.right = right[0];
		}

		if (left == null) {
			return new BinaryTree[] { root, right == null ? root : right[1] };
		}
		
		left[1].right = root;
		root.left = left[1];
		
    return new BinaryTree[] { left[0], right == null ? root : right[1] };
  }
  // This is the class of the input root. Do not edit it.
  static class BinaryTree {
    int value;
    BinaryTree left = null;
    BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
}