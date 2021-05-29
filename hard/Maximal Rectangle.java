class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int[] array = new int[colLength];
        int maxArea = 0;
        
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                array[j] = matrix[i][j] == '0'? 0 : array[j] + 1;
            }
            maxArea = Math.max(maxArea, maxRectangle(array));
        }
        
        return maxArea;
    }
    
    // find the largest area under a histogram
    public int maxRectangle(int[] heights) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(-1);
        int max = 0;
        for (int i=0;i<heights.length;++i) {
            if (deque.peekFirst() == -1 || heights[deque.peek()] < heights[i]) deque.addFirst(i);
            
            else {
                while (deque.peekFirst() != -1 && heights[deque.peek()] >= heights[i]) {
                    int top = deque.pollFirst();
                    int area = heights[top] * (i - deque.peek() - 1);
                    max = Math.max(area, max);
                }
                deque.addFirst(i);
            }
        }
        
        while (deque.peekFirst() != -1) {
            int top = deque.pollFirst();
            int area = heights[top] * (heights.length - deque.peek() - 1);
            max = Math.max(area, max);
        }
        
        return max;
    }
}