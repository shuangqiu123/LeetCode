// https://www.algoexpert.io/questions/Right%20Smaller%20Than
import java.util.*;

class Program {
  public static List<Integer> rightSmallerThan(List<Integer> array) {
		if (array.isEmpty()) {
			return new ArrayList<>();
		}
		
		ArrayDeque<Integer> result = new ArrayDeque<>();
		TreeNode node = new TreeNode(array.get(array.size() - 1));

		result.addFirst(0);
		
		for (int i = array.size() - 2; i >= 0; i--) {
			insertNode(array.get(i), node);
			result.addFirst(findNodeNumsLessThanValue(array.get(i), node));
		}
		
    return new ArrayList<Integer>(result);
  }
	
	private static int findNodeNumsLessThanValue(int value, TreeNode node) {
		if (node == null) {
			return 0;
		}
		if (node.value == value) {
			return node.leftSize;
		}
		else if (node.value < value) {
			return 1 + node.leftSize + findNodeNumsLessThanValue(value, node.right);
		}
		return findNodeNumsLessThanValue(value, node.left);
	}
	
	private static void insertNode(int value, TreeNode node) {
		if (node.value <= value) {
			if (node.right == null) {
				node.right = new TreeNode(value);
			}
			else {
				insertNode(value, node.right);
			}
		}
		else {
			if (node.left == null) {
				node.left = new TreeNode(value);
			}
			else {
				insertNode(value, node.left);
			}
			node.leftSize++;
		}
	}
}
class TreeNode {
	int value;
	int leftSize;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int value) {
		this.value = value;
	}
}