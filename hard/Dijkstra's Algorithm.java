import java.util.*;

class Program {
  public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
    int[] result = new int[edges.length];
		Node[] nodes = new Node[edges.length];
		PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2)->n1.distance - n2.distance);
		Arrays.fill(result, -1);
		
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new Node(Integer.MAX_VALUE, i);
		}
		nodes[start].distance = 0; 
		queue.add(nodes[start]);
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int nodeIndex = node.node;
			result[nodeIndex] = node.distance;
			
			for (int[] pair : edges[nodeIndex]) {
				int distance = pair[1] + node.distance;
				if (distance < nodes[pair[0]].distance) {
					nodes[pair[0]].distance = distance;
					queue.add(nodes[pair[0]]);
				}
			}
		}
		
	
    return result;
  }
}

class Node {
	int distance;
	int node;
	
	Node(int distance, int node) {
		this.distance = distance;
		this.node = node;
	}
}