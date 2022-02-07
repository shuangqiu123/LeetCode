// leetcode 74
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m - 1;
        int mid = left + (right - left) / 2;
        
        while (left < right) {
            if (matrix[mid][0] > target) {
                right = mid - 1;
            }
            else if (matrix[mid][n - 1] < target) {
                left = mid + 1;
            }
            else {
                break;
            }
            mid = left + (right - left) / 2;
        }
        int row = mid;
        
        if (row < 0 || row >= m) return false;
        
        left = 0;
        right = n - 1;
        mid = left + (right - left) / 2;
        
        while (left <= right) {
            if (matrix[row][mid] > target) {
                right = mid - 1;
            }
            else if (matrix[row][mid] < target) {
                left = mid + 1;
            }
            else {
                return true;
            }
            mid = left + (right - left) / 2;
        }
        return false;
    }
}