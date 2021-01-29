class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1, k=m+n-1;
        
        while (i>=0 && j>=0) {
            if (nums2[j] >= nums1[i]) {
                nums1[k--] = nums2[j--];
            } else {
                nums1[k--] = nums1[i--];
            }
        }
        // edge case nums1=[7,8,9,0,0,0] nums2 = [1,2,3]
        while (j>=0) nums1[k--] = nums2[j--];
    }
}