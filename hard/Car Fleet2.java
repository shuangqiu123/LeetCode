/**
* Maintain a monotonically decreasing stack to track the car speed
* O(n) time and space
*/
class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = cars.length;
        double[] result = new double[n];
        Arrays.fill(result, -1.0);
        
        for (int i = n - 1; i >= 0; i--) {
            int position = cars[i][0];
            int speed = cars[i][1];
            
            while (!deque.isEmpty()) {
                int topIndex = deque.peekLast();
                int topPosition = cars[topIndex][0];
                int topSpeed = cars[topIndex][1];
                
                if (speed <= topSpeed || 1.0 * (topPosition - position) / (speed - topSpeed) >= result[topIndex] && result[topIndex] > 0) {
                    deque.pollLast();
                }
                else {
                    break;
                }
            }
            
            if (!deque.isEmpty()) {
                int topIndex = deque.peekLast();
                int topPosition = cars[topIndex][0];
                int topSpeed = cars[topIndex][1];
                result[i] = 1.0 * (topPosition - position) / (speed - topSpeed);
            }
            
            deque.addLast(i);
        }
        
        
        return result;
    }
}