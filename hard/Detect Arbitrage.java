import java.util.*;

/**
* Bellman Ford Algorithm: find sigle source shortest path: can detect negative weight graph
* O(n^3) time complexity and O(n) space complexity
*/
class Program {

  public boolean detectArbitrage(ArrayList<ArrayList<Double>> exchangeRates) {
  	constructGraph(exchangeRates);
    return detectNegativeCircle(0, exchangeRates);
  }
	
	private boolean detectNegativeCircle(int currency, ArrayList<ArrayList<Double>> exchangeRates) {
		double[] distance = new double[exchangeRates.size()];
		Arrays.fill(distance, Double.MAX_VALUE);
		distance[currency] = 0;
		
		// Bellman Ford Algorithm
		for (int unused = 0; unused < exchangeRates.size(); unused++) {
			if (!relaxEdgesAndUpdateDistances(exchangeRates, distance)) {
				return false;
			}
		}
		
		return relaxEdgesAndUpdateDistances(exchangeRates, distance);
	}
	
	private boolean relaxEdgesAndUpdateDistances(ArrayList<ArrayList<Double>> exchangeRates, double[] distance) {
		boolean update = false;
		
		for (int sourceId = 0; sourceId < exchangeRates.size(); sourceId++) {
			ArrayList<Double> edges = exchangeRates.get(sourceId);
			for (int destId = 0; destId < exchangeRates.size(); destId++) {
				double sourceToDest = edges.get(destId) + distance[sourceId];
				if (sourceToDest < distance[destId]) {
					distance[destId] = sourceToDest;
					update = true;
				}
			}
		}
		
		return update;
 	}
	
	private void constructGraph(ArrayList<ArrayList<Double>> exchangeRates) {
		for (ArrayList<Double> rates : exchangeRates) {
			for (int i = 0; i < rates.size(); i++) {
				rates.set(i, -Math.log10(rates.get(i)));
			}
		}
	}
}
