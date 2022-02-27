// leetcode  155
class MinStack {
    ArrayDeque<Integer> stack;
    ArrayDeque<Integer> minElementStack;
    int currentMin = Integer.MAX_VALUE;

    public MinStack() {
        stack = new ArrayDeque<>();
        minElementStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (val <= currentMin) {
            currentMin = val;
            minElementStack.push(currentMin);
        }
    }
    
    public void pop() {
        int val = stack.pop();
        if (val == currentMin) {
            minElementStack.pop();
            if (minElementStack.size() > 0) {
                currentMin = minElementStack.peek();
            }
            else {
                currentMin = Integer.MAX_VALUE;
            }
        }
    }
    
    // -2, 0, -3
    
    // -2, -3
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return currentMin;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */