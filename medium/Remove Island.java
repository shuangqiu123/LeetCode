import java.util.*;

class Program {
	
	/*
	O (mn) time
	*/
  public int[][] removeIslands(int[][] matrix) {
    
		for (int i = 0; i < matrix.length; i++) {
			dfsMarkIsland(0, i, matrix);
			dfsMarkIsland(matrix.length - 1, i, matrix);
		}
		
		for (int i = 0; i < matrix[0].length; i++) {
			dfsMarkIsland(i, 0, matrix);
			dfsMarkIsland(i, matrix[0].length - 1, matrix);
		}
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 2) {
					matrix[i][j] = 1;
				}
				else if (matrix[i][j] == 1) {
					matrix[i][j] = 0;
				}
			}
		}
		
    return matrix;
  }
	
	public void dfsMarkIsland(int row, int col, int[][] matrix) {
		if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) {
			return;
		}
		if (matrix[row][col] == 0 || matrix[row][col] == 2) {
			return;
		}
		
		matrix[row][col] = 2;
		
		dfsMarkIsland(row + 1, col, matrix);
		dfsMarkIsland(row - 1, col, matrix);
		dfsMarkIsland(row, col + 1, matrix);
		dfsMarkIsland(row, col - 1, matrix);
	}
	
}
