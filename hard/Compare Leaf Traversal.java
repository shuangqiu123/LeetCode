//https://www.algoexpert.io/questions/Compare%20Leaf%20Traversal

import java.util.*;

class Program {
  // This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  public boolean compareLeafTraversal(BinaryTree tree1, BinaryTree tree2) {
    ArrayDeque<BinaryTree> stack1 = new ArrayDeque<>();
		ArrayDeque<BinaryTree> stack2 = new ArrayDeque<>();
		BinaryTree node1 = tree1;
		BinaryTree node2 = tree2;
		Integer comparingValue = null;
		
		while ((node1 != null || !stack1.isEmpty()) && (node2 != null || !stack2.isEmpty())) {
			while (node1 != null || !stack1.isEmpty()) {
				while (node1 != null) {
					stack1.push(node1);
					node1 = node1.left;
				}
				node1 = stack1.pop();
				if (node1.left == null && node1.right == null) {
					comparingValue = node1.value;
					node1 = node1.right;
					break;
				}
				node1 = node1.right;
			}
			while (node2 != null || !stack2.isEmpty()) {
				while (node2 != null) {
					stack2.push(node2);
					node2 = node2.left;
				}
				node2 = stack2.pop();
				if (node2.left == null && node2.right == null) {
					if (comparingValue == null || comparingValue != node2.value) {
						return false;
					}
					if (comparingValue == node2.value) {
						comparingValue = null;
						node2 = node2.right;
						break;
					}
				}
				node2 = node2.right;
			}
		}
		
    return comparingValue == null;
  }
}
