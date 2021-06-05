import java.util.*;

/**
O(n ^ 2) time complexity
O(n ^ 2) space complexity
*/
class Program {
	private static int rectangles;
	
  public static int rectangleMania(List<Integer[]> coords) {
    Map<String, Map<Integer, List<Point>>> map = new HashMap<>();
		List<Point> points = new ArrayList<>();
		rectangles = 0;
		
		for (Integer[] coord : coords) {
			points.add(new Point(coord[0], coord[1]));
			Map<Integer, List<Point>> directions = new HashMap<>();
			directions.put(1, new ArrayList<>());
			directions.put(2, new ArrayList<>());
			directions.put(3, new ArrayList<>());
			directions.put(4, new ArrayList<>());
			map.put(coord[0] + "," + coord[1], directions);
		}
		
		for (int i = 0; i < points.size(); i++) {
			Map<Integer, List<Point>> directions = map.get(points.get(i).id);
			for (int j = 0; j < points.size(); j++) {
				if (j == i) {
					continue;
				}
				addDirections(points.get(i), points.get(j), directions);
			}
		}
		
		for (Point point : points) {
			dfsFindRectangle(map, point, point, 1);
		}
		
    return rectangles;
  }
	
	private static void addDirections(Point x, Point y, Map<Integer, List<Point>> directions) {
		if (x.x == y.x && x.y == y.y) {
			return;
		}
		else if (x.x == y.x) {
			if (x.y < y.y) {
				directions.get(1).add(y);
			}
			else {
				directions.get(3).add(y);
			}
		}
		else if (x.y == y.y) {
			if (x.x < y.x) {
				directions.get(2).add(y);
			}
			else {
				directions.get(4).add(y);
			}
		}
	}
	
	private static void dfsFindRectangle(Map<String, Map<Integer, List<Point>>> map, Point origin, Point point, int direction) {
		if (direction == 5) {
			if (point.x == origin.x && point.y == origin.y) {
				rectangles++;
			}
			return;
		}
		
		for (Point next : map.get(point.id).get(direction)) {
			dfsFindRectangle(map, origin, next, direction + 1);
		}
	}
	
	
  static class Point {
    public int x;
    public int y;
		public String id;
		
		
    public Point(int x, int y) {
      this.x = x;
      this.y = y;
			id = x + "," + y;
    }
		
		@Override
		public String toString() {
			return id;
		} 
  }
}
