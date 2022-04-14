// https://www.algoexpert.io/questions/Square%20of%20Zeroes
import java.util.*;

class Program {
  public static boolean squareOfZeroes(List<List<Integer>> matrix) {
		int size = matrix.size();
    int[][] zeroInRow = new int[size][size];
		int[][] zeroInCol = new int[size][size];
		
		
		for (int i = 0; i < size; i++) {
			int rowZeros = 0;
			int colZeros = 0;
			for (int j = size - 1; j >= 0; j--) {
				if (matrix.get(i).get(j) == 0) {
					rowZeros++;
				}
				else {
					rowZeros = 0;
				}
				zeroInRow[i][j] = rowZeros;
				
				if (matrix.get(j).get(i) == 0) {
					colZeros++;
				}
				else {
					colZeros = 0;
				}
				zeroInCol[j][i] = colZeros;
			}
		}
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (matrix.get(i).get(j) == 0 && isValidSquare(zeroInRow, zeroInCol, i, j)) {
					return true;
				}
			}
		}
		
    return false;
  }
	
	// O(n)
	private static boolean isValidSquare(int[][] zeroInRow, int[][] zeroInCol, int row, int col) {
		int maxLength = Math.min(zeroInRow[row][col], zeroInCol[row][col]);
		
		for (int i = 2; i <= maxLength; i++) {
			int topLeftToTopRightZeros = i;
			int topLeftToBottomLeftZeros = i;
			int BottomLeftToBottomRightZeros = Math.min(i, zeroInRow[row + i - 1][col]);
			int TopRightToBottomRightZeros = Math.min(i, zeroInCol[row][col + i - 1]);
			
			if (BottomLeftToBottomRightZeros == TopRightToBottomRightZeros &&  BottomLeftToBottomRightZeros == i) {
				return true;
			}
		}
		
		return false;
	}
}
