// https://www.algoexpert.io/questions/Validate%20Three%20Nodes
import java.util.*;

class Program {
  // This is an input class. Do not edit.
  static class BST {
    public int value;
    public BST left = null;
    public BST right = null;

    public BST(int value) {
      this.value = value;
    }
  }

  public boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
		if (isAncestor(nodeOne, nodeTwo)) {
			return isAncestor(nodeTwo, nodeThree);
		}
		if (isAncestor(nodeThree, nodeTwo)) {
			return isAncestor(nodeTwo, nodeOne);
		}
		
    return false;
  }
	
	// is node1 ancestor of node2
	// O(d) where the distance is between node1 and node 3
	public boolean isAncestor(BST nodeOne, BST nodeTwo) {
		if (nodeOne == null) {
			return false;
		}
		if (nodeOne.value < nodeTwo.value) {
			return isAncestor(nodeOne.right, nodeTwo);
		}
		else if (nodeOne.value > nodeTwo.value) {
			return isAncestor(nodeOne.left, nodeTwo);
		}
		return true;
	}
}
