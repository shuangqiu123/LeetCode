class Solution {
    
    class Point implements Comparable<Point> {
        int x;
        int y;
        boolean isStart;
        
        public Point(int x,int y,boolean isStart) {
            this.x = x;
            this.y = y;
            this.isStart = isStart;
        }
        
        @Override
        public int compareTo(Point p) {
            if (this.x != p.x) {
                return this.x - p.x;
            }
            
            if (p.isStart && isStart) {
                return p.y - y;
            }
            if (!p.isStart && !isStart) {
                return y - p.y;
            }
            return isStart?-1:1;
        }
        
        // use for debug
        @Override
        public String toString() {
            return x+","+y+","+isStart;
        }
    }
    
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<Point> points = new ArrayList<>();
        
        // add points (x,y,isStart)
        for (int[] building: buildings) {
            points.add(new Point(building[0],building[2],true));
            points.add(new Point(building[1],building[2],false));
        }
        // sort them to avoid edge case
        Collections.sort(points);
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.add(0);
        
        
        for (int i=0;i<points.size();++i) {
            Point point = points.get(i);
            int height = queue.peek();
            if (point.isStart) {
                // if it is higher than the current max in the queue, it is a skyline point
                if (point.y > height) {
                    res.add(List.of(point.x,point.y));
                }
                queue.add(point.y);
            } else { // the end of a building
                queue.remove(point.y);
                // if the building removed is the highest, the point is a skyline point
                if (queue.peek() < height) {
                    res.add(List.of(point.x,queue.peek()));
                }
            }   
        }
        
        return res;
    }
}