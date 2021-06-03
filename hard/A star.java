import java.util.*;

class Program {

  public int[][] aStarAlgorithm(int startRow, int startCol, int endRow, int endCol, int[][] graph) {
		Node[][] nodes = initialiseNodes(graph);
    	PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2)->n1.fScore - n2.fScore);
		int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		Node startNode = nodes[startRow][startCol];
		Node endNode = nodes[endRow][endCol];
		int totalRow = graph.length;
		int totalCol = graph[0].length;
		
		startNode.gScore = 0;
		startNode.fScore = heuristics(startRow, startCol, endRow, endCol);
		pq.add(startNode);
		
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			
			if (node.id.equals(endNode.id)) {
				break;
			}
			
			for (int[] direction : directions) {
				int row = node.row + direction[0];
				int col = node.col + direction[1];
				
				if (row < 0 || row >= totalRow || col < 0 || col >= totalCol) {
					continue;
				}
				if (nodes[row][col].value == 1) {
					continue;
				}
				int distanceToNeighbour = node.gScore + 1;
				
				if (distanceToNeighbour >= nodes[row][col].gScore) {
					 continue;
				}
				nodes[row][col].prev = node;
				nodes[row][col].gScore = distanceToNeighbour;
				nodes[row][col].fScore = distanceToNeighbour + heuristics(row, col, endRow, endCol);
				
				if (pq.contains(nodes[row][col])) {
					pq.remove(nodes[row][col]);
				}
				pq.add(nodes[row][col]);
			}
		}
		
    return reconstructPath(endNode);
  }
	
	public int heuristics(int row, int col, int endRow, int endCol) {
		return Math.abs(row - endRow) + Math.abs(col - endCol);
	}
	
	public Node[][] initialiseNodes(int[][] graph) {
		Node[][] nodes = new Node[graph.length][graph[0].length];
		
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[0].length; j++) {
				nodes[i][j] = new Node(i, j, graph[i][j]);
			}
		}
		return nodes;
	}
	
	public int[][] reconstructPath(Node endNode) {
		ArrayList<int[]> result = new ArrayList<>();
		if (endNode.prev == null) {
			return new int[][]{};
		}
		Node currentNode = endNode;
		
		while (currentNode != null) {
			result.add(new int[] {currentNode.row, currentNode.col});
			currentNode = currentNode.prev;
		}
		
		Collections.reverse(result);
		
		return result.toArray(new int[result.size()][]);
	}
}

class Node {
	String id;
	int row;
	int col;
	int value;
	int gScore;
	int fScore;
	Node prev;
	
	Node(int x, int y, int value) {
		row = x;
		col = y;
		id = x + "," + y;
		this.value = value;
		gScore = Integer.MAX_VALUE;
		fScore = Integer.MAX_VALUE;
	}
}