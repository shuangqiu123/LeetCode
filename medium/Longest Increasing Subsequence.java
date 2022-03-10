// leetcode 300
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] array = new int[nums.length];
        Arrays.fill(array, Integer.MIN_VALUE);
        int index = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int target = nums[i];
            int left = 0;
            int right = index;
            int mid = left + (right - left) / 2;

            while (left < right) {
                if (array[mid] < target) {
                    left = mid + 1;
                }
                else {
                    right = mid;
                }
                mid = left + (right - left) / 2;
            }
            array[mid] = target;

            if (mid == index) {
                index++;
            }
        }
        
        return index;
    }
}