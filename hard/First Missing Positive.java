// leetcode 41
class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[i];
                int j = nums[i] - 1;
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        
        for (int i = 0; i < len; i++) {
            if (i != nums[i] - 1) {
                return i + 1;
            }
        }
        return nums[len - 1] + 1;
    }
}