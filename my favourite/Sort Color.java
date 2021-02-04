class Solution {

    // simple version of quick sort partition
    public void sortColors(int[] nums) {
        // first greater and first equal
        int pivot = 1, fg = nums.length-1, fe = 0;
        int i = 0;
        while (i < nums.length) {
            while (i < fg && nums[i] > pivot) {
                swap(nums,i,fg--);
            }
            while (i > fe && nums[i] < pivot) {
                swap(nums,i,fe++);
            }
            ++i;
        }
        
    }
    
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}