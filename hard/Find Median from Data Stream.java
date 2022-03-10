// leetcode 295

class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>((e1, e2) -> e2 - e1);
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (left.size() == right.size()) {
            // [1]  [3]  [4]
            if (left.isEmpty() || num <= right.peek()) {
                left.add(num);
            }
            else {
                left.add(right.poll());
                right.add(num);
            }
        }
        else {
            if (num >= left.peek()) {
                right.add(num);
            }
            else {
                right.add(left.poll());
                left.add(num);
            }
        }
    }
    
    public double findMedian() {
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        }
        return left.peek();
    }
}