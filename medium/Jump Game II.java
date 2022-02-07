// leetcode 45
class Solution {
    public int jump(int[] nums) {
        int length = nums.length;
        int farthest = 0;
        int end = 0;
        int time = 0;

        for (int i = 0; i < length - 1; i++) {
            if (farthest < nums[i] + i) {
                farthest = nums[i] + i;
            }
            if (end == i) {
                time++;
                end = farthest;
            }
        }
        
        return time;
    }
}