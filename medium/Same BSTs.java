// https://www.algoexpert.io/questions/Same%20BSTs
import java.util.*;
/*
O(n^2) for space and time
*/
class Program {
  public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {

    if (arrayOne.size() != arrayTwo.size()) {
			return false;
		}

		if (arrayOne.isEmpty()) {
			return true;
		}

		if (arrayOne.get(0) != arrayTwo.get(0)) {
			return false;
		}

		List<Integer> arrayOneLessThanRoot = new ArrayList<>();
		List<Integer> arrayOneGreaterThanRoot = new ArrayList<>();
		List<Integer> arrayTwoLessThanRoot = new ArrayList<>();
		List<Integer> arrayTwoGreaterThanRoot = new ArrayList<>();
		
		// O(n)
		for (int i = 1; i < arrayOne.size(); i++) {
			if (arrayOne.get(i) >= arrayOne.get(0)) {
				arrayOneGreaterThanRoot.add(arrayOne.get(i));
			}
			else if (arrayOne.get(i) < arrayOne.get(0)) {
				arrayOneLessThanRoot.add(arrayOne.get(i));
			}
			
			if (arrayTwo.get(i) >= arrayTwo.get(0)) {
				arrayTwoGreaterThanRoot.add(arrayTwo.get(i));
			}
			else if (arrayTwo.get(i) < arrayTwo.get(0)) {
				arrayTwoLessThanRoot.add(arrayTwo.get(i));
			}
		}
		// O (n)
    return sameBsts(arrayOneLessThanRoot, arrayTwoLessThanRoot) && sameBsts(arrayOneGreaterThanRoot, arrayTwoGreaterThanRoot);
  }
}