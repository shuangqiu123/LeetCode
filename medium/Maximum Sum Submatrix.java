// https://www.algoexpert.io/questions/Maximum%20Sum%20Submatrix
import java.util.*;

class Program {

  public int maximumSumSubmatrix(int[][] matrix, int size) {
    int m = matrix.length;
		int n = matrix[0].length;
		int maxSum = Integer.MIN_VALUE;
		int[][] matrixSum = new int[m][n - size + 1];
		
		for (int i = 0; i < m; i++) {
			int sum = 0;
			for (int j = 0; j < n; j++) {
				sum += matrix[i][j];
				if (j >= size - 1) {
					matrixSum[i][j - size + 1] = sum;
					sum -= matrix[i][j - size + 1];
				}
			}
		}
		
		for (int i = 0; i < n - size + 1; i++) {
			int sum = 0;
			for (int j = 0; j < m; j++) {
				sum += matrixSum[j][i];
				if (j >= size - 1) {
					maxSum = Math.max(sum, maxSum);
					sum -= matrixSum[j - size + 1][i];
				}
			}
		}
		
    return maxSum;
  }
}

// 8, 2, 4
// -4, 10, 11
// 20, 8, 0
// -7, -16, -6


// 12, 12, 15
// 16, 18, 11
// 13, -8, -6