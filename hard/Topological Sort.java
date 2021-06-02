import java.util.*;

class Program {
  public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
    boolean[][] matrix = new boolean[jobs.size()][jobs.size()];
		int[] indegrees = new int[jobs.size()];
		Queue<Integer> queue = new ArrayDeque<>();
		List<Integer> result = new ArrayList<>();
		Map<Integer, Integer> jobToIndex = new HashMap<>();
		
		for (int i = 0; i < jobs.size(); i++) {
			jobToIndex.put(jobs.get(i), i);
		}
		
		
		for (Integer[] dep : deps) {
			matrix[jobToIndex.get(dep[0])][jobToIndex.get(dep[1])] = true; 
		}
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j]) {
					indegrees[j]++;
				}
			}
		}
		
		for (int i = 0; i < indegrees.length; i++) {
			if (indegrees[i] == 0) {
				queue.add(i);
				indegrees[i] = -1;
			}
		}
		
		while (!queue.isEmpty()) {
			int task = queue.poll();
			result.add(jobs.get(task));
			
			for (int i = 0; i < matrix.length; i++) {
				if (matrix[task][i]) {
					indegrees[i]--;
					if (indegrees[i] == 0) {
						queue.add(i);
						indegrees[i] = -1;
					}
				}
			}
		}
		
		for (int i = 0; i < indegrees.length; i++) {
			if (indegrees[i] > 0) {
				return new ArrayList<>();
			}
		}
		
    return result;
  }
}
