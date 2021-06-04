import java.util.*;

class Program {
  public static int airportConnections(
      List<String> airports, List<List<String>> routes, String startingAirport) {
    Map<String, AirportNode> graph = constructGraph(airports, routes);
		List<AirportNode> unreachableAirportNodes = getUnreachableAirportNodes(graph, airports, startingAirport);
		
		markUnreachableConnections(graph, unreachableAirportNodes);
		
    return getMinNumberOfConnections(graph, unreachableAirportNodes);
  }
	
	
	// O (r + a)
	public static Map<String, AirportNode> constructGraph(List<String> airports, List<List<String>> routes) {
		Map<String, AirportNode> graph = new HashMap<>();
		
		for (String airport : airports) {
			graph.put(airport, new AirportNode(airport));
		}
		
		for (List<String> route: routes) {
			graph.get(route.get(0)).connections.add(route.get(1));
		}
		
		return graph;
	}
	
	// O (a + r)  time
	// O(a) space
	public static List<AirportNode> getUnreachableAirportNodes(Map<String, AirportNode> graph, List<String> airports, String startingAirport) {
		Set<String> visited = new HashSet<>();
		List<AirportNode> result = new ArrayList<>();
		dfs(graph, startingAirport, visited);
		
		for (String airport : airports) {
			if (!visited.contains(airport)) {
				graph.get(airport).isReachable = false;
				result.add(graph.get(airport));
			}
		}
		return result;
	}
	
	public static void markUnreachableConnections(Map<String, AirportNode> graph, List<AirportNode> unreachableAirportNodes) {
		for (AirportNode node : unreachableAirportNodes) {
			List<String> unreachableConnections = new ArrayList<>();
			dfsFindUnreachableConnection(graph, node.airport, unreachableConnections, new HashSet<>());
			node.unReachableConnections = unreachableConnections;
		}
	}
	
	// O(alog(a) + a + r)
	public static int getMinNumberOfConnections(Map<String, AirportNode> graph, List<AirportNode> unreachableAirportNodes) {
		Collections.sort(unreachableAirportNodes, (a1, a2) -> a2.unReachableConnections.size() - a1.unReachableConnections.size());
		int newConnections = 0;
		
		for (AirportNode node : unreachableAirportNodes) {
			if (node.isReachable) {
				continue;
			}
			newConnections++;
			for (String airport : node.unReachableConnections) {
				graph.get(airport).isReachable = true;
			}
			
		}
		
		return newConnections;
	}
	
	
	public static void dfs(Map<String, AirportNode> graph, String cur, Set<String> visited) {
		if (visited.contains(cur)) {
			return;
		}
		visited.add(cur);
		for (String airport : graph.get(cur).connections) {
			dfs(graph, airport, visited);
		}
	}
	
	
	public static void dfsFindUnreachableConnection(Map<String, AirportNode> graph, String cur, List<String> unreachableConnections, Set<String> visited) {
		if (visited.contains(cur)) {
			return;
		}
		if (graph.get(cur).isReachable) {
			return;
		}
		unreachableConnections.add(cur);
		visited.add(cur);
		
		for (String airport : graph.get(cur).connections) {
			dfsFindUnreachableConnection(graph, airport, unreachableConnections, visited);
		}
	}
}


class AirportNode {
	Set<String> connections;
	boolean isReachable;
	List<String> unReachableConnections;
	String airport;
	
	AirportNode(String airport) {
		this.airport = airport;
		connections = new HashSet<>();
		unReachableConnections = new ArrayList<>();
		isReachable = true;
	}
}
