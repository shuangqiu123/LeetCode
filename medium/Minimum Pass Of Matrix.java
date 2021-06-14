import java.util.*;

class Program {

  public int minimumPassesOfMatrix(int[][] matrix) {
    Queue<Node> queue = new ArrayDeque<>();
		int[][] neighbours = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
		int negatives = 0;
		int pass = 0;
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] > 0) {
					queue.offer(new Node(i, j));
				}
				else if (matrix[i][j] < 0) {
					negatives++;
				}
			}
		}
		
		while (!queue.isEmpty() && negatives > 0) {
			int currentSize = queue.size();
			pass++;
			
			while (currentSize > 0) {
				Node node = queue.poll();
				for (int[] neighbour : neighbours) {
					int nextX = node.x + neighbour[0];
					int nextY = node.y + neighbour[1];
					
					if (nextX < 0 || nextY < 0 || nextX >= matrix.length || nextY >= matrix[0].length) {
						continue;
					}
					if (matrix[nextX][nextY] >= 0) {
						continue;
					}
					matrix[nextX][nextY] *= -1;
					queue.add(new Node(nextX, nextY));
					negatives--;
				}
				currentSize--;
			}
		}
    return negatives > 0? -1 : pass;
  }
}

class Node {
	int x;
	int y;
	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
