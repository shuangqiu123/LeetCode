import java.util.*;
/**
* Detect bridges of the graph
* time complexity O (V + E) space O(V)
 */
class Program {

  public boolean twoEdgeConnectedGraph(int[][] edges) {
    if (edges.length == 0) {
			return true;
		}
		int[] arrivalTimes = new int[edges.length];
		Arrays.fill(arrivalTimes, -1);
		int startVertex = 0;
		
    if (getMinimumArrivalTimeOfAncestors(edges, arrivalTimes, -1, startVertex, 0) == -1) {
			return false;
		}
		
		return areAllVerticesVisited(arrivalTimes);
  }
	
	private boolean areAllVerticesVisited(int[] arrivalTimes) {
		for (int time : arrivalTimes) {
			if (time == -1) {
				return false;
			}
		}
		
		return true;
	}

	private int getMinimumArrivalTimeOfAncestors(int[][] edges, int[] arrivalTimes, int ancestor, int currentVertex, int time) {
		arrivalTimes[currentVertex] = time;
		int minimumArrivalTime = time;
		
		for (int destination : edges[currentVertex]) {
			if (arrivalTimes[destination] == -1) {
				minimumArrivalTime = Math.min(minimumArrivalTime, getMinimumArrivalTimeOfAncestors(edges, arrivalTimes, currentVertex, destination, time + 1));
			}
			else if (destination != ancestor) {
				minimumArrivalTime = Math.min(minimumArrivalTime, arrivalTimes[destination]);
			}
		}
		
		if (minimumArrivalTime == time && ancestor != -1) {
			return -1;
		}
		
		return minimumArrivalTime;
	}
}
