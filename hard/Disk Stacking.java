// https://www.algoexpert.io/questions/Disk%20Stacking
import java.util.*;

class Program {
  public static List<Integer[]> diskStacking(List<Integer[]> disks) {
    int size = disks.size();
		int[] dp = new int[size];
		int[] sequence = new int[size];
		int maxHeight = 0;
		int maxHeightIndex = 0;

		Arrays.fill(sequence, -1);
		Collections.sort(disks, (d1, d2) -> d1[2] - d2[2]);
		
		for (int i = 0; i < size; i++) {
			dp[i] = disks.get(i)[2];
		}
		
		for (int i = 1; i < size; i++) {
			Integer[] currentDisk = disks.get(i);
			for (int j = 0; j < i; j++) {
				Integer[] otherDisk = disks.get(j);
				if (isValidPlacement(otherDisk, currentDisk)) {
					if (dp[i] <= currentDisk[2] + dp[j]) {
						dp[i] = currentDisk[2] + dp[j];
						sequence[i] = j;
					}
				}
			}
			if (dp[i] > maxHeight) {
				maxHeight = dp[i];
				maxHeightIndex = i;
			}
		}
		
		List<Integer[]> result = new LinkedList<>();
		int index = maxHeightIndex;
		while (index != -1) {
			result.add(0, disks.get(index));
			index = sequence[index];
		}
		
    return result;
  }
	
	private static boolean isValidPlacement(Integer[] currentDisk, Integer[] otherDisk) {
		return currentDisk[0] < otherDisk[0] && currentDisk[1] < otherDisk[1] && currentDisk[2] < otherDisk[2];
	}
}
