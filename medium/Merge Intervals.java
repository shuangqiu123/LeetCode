// leetcode 56
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        LinkedList<int[]> lists = new LinkedList<>();
        
        for (int[] interval : intervals) {
            if (lists.isEmpty()) {
                lists.add(interval);
                continue;
            }
            
            // 1, 4  x, 5
            if (interval[1] > lists.peekLast()[1]) {
                // 1, 4  3, 5
                if (interval[0] <= lists.peekLast()[1]) {
                    lists.peekLast()[1] = interval[1];
                }
                // 1, 4 5, 6
                else {
                    lists.add(interval);
                }
            }
            
            // 1, 4  x, 3
        }
        
        return lists.toArray(new int[lists.size()][]);
    }
}