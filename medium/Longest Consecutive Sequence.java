// leetcode 128

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> uniqueNums = new HashSet<>();
        
        for (int num : nums) {
            uniqueNums.add(num);
        }
        
        int maxLength = 0;
        
        for (int num : uniqueNums) {
            if (uniqueNums.contains(num - 1)) {
                continue;
            }
            else {
                int count = 1;
                while (uniqueNums.contains(++num)) {
                    count++;
                }
                maxLength = Math.max(maxLength, count);
            }
        }
        
        return maxLength;
    }
}