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
	
	BinaryTree targetNode = null;
	int target = 0;
  public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
		Map<Integer, BinaryTree> valueToParent = new HashMap<>();
		targetNode = null;
		this.target = target;
		computeValueToParent(tree, null, valueToParent);
		
    return bfsFindNodes(valueToParent, k);
  }
	
	private ArrayList<Integer> bfsFindNodes(Map<Integer, BinaryTree> map, int k) {
		ArrayList<Integer> result = new ArrayList<>();
		Set<Integer> visited = new HashSet<>();
		Queue<BinaryTree> queue = new ArrayDeque<>();
		queue.offer(targetNode);
		visited.add(targetNode.value);
		while (!queue.isEmpty()) {
			if (k == 0) {
				break;
			}
			int currentSize = queue.size();
			for (int i = 0; i < currentSize; i++) {
				BinaryTree node = queue.poll();
				if (map.get(node.value) != null && !visited.contains(map.get(node.value).value)) {
					queue.offer(map.get(node.value));
					visited.add(map.get(node.value).value);
				}
				if (node.left != null && !visited.contains(node.left.value)) {
					queue.offer(node.left);
					visited.add(node.left.value);
				}
				if (node.right != null && !visited.contains(node.right.value)) {
					queue.offer(node.right);
					visited.add(node.right.value);
				}
			}
			
			k--;
		}
		
		queue.forEach(e->result.add(e.value));
		
		return result;
	}
	
	private void computeValueToParent(BinaryTree current, BinaryTree parent, Map<Integer, BinaryTree> valueToParent) {
		if (current == null) {
			return;
		}
		if (current.value == target) {
			targetNode = current;
		}
		valueToParent.put(current.value, parent);
		computeValueToParent(current.left, current, valueToParent);
		computeValueToParent(current.right, current, valueToParent);
	}
}

