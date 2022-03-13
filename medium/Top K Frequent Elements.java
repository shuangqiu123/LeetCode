// leetcode 347
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        PriorityQueue<Number> queue = new PriorityQueue<>((n1, n2) -> n1.count - n2.count);
        
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        for (int num : count.keySet()) {
            queue.add(new Number(num, count.get(num)));
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] result = new int[queue.size()];
        int i = queue.size() - 1;
        while (!queue.isEmpty()) {
            result[i--] = queue.poll().num;
        }
        
        return result;
    }
    // kn + nlogk
    class Number {
        int num;
        int count;
        
        Number(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}