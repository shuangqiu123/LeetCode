import java.util.*;

class Program {

  public ArrayList<ArrayList<Integer>> solveSudoku(ArrayList<ArrayList<Integer>> board) {
	dfsFillBoard(board);
    return board;
  }
	
	
	private boolean dfsFillBoard(ArrayList<ArrayList<Integer>> board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board.get(i).get(j) == 0) {
					for (int k = 1; k <= 9; k++) {
						if (!isValid(board, i, j, k)) {
							continue;
						}
						board.get(i).set(j, k);
						if (dfsFillBoard(board)) {
							return true;
						}
						board.get(i).set(j, 0);
					}
					return false;
				}
			}
		}
		
		return true;
	}
	
	private boolean isValid(ArrayList<ArrayList<Integer>> board, int row, int col, int value) {
		for (int i = 0; i < 9; i++) {
			if (board.get(row).get(i) == value) {
				return false;
			}
			if (board.get(i).get(col) == value) {
				return false;
			}
		}
		
		int startGridRow = (row / 3) * 3;
		int startGridCol = (col / 3) * 3;
		
		for (int i = startGridRow; i < startGridRow + 3; i++) {
			for (int j = startGridCol; j < startGridCol + 3; j++) {
				if (board.get(i).get(j) == value) {
					return false;
				}
			}
		}
		
		return true;
	}
}
