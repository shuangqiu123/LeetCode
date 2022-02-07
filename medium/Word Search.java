// leetcode 79
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int row, int col, int position) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        if (board[row][col] == '.') {
            return false;
        }
        if (board[row][col] != word.charAt(position)) {
            return false;
        }
        if (position == word.length() - 1) {
            return true;
        }
        board[row][col] = '.';
        
        if (dfs(board, word, row + 1, col, position + 1) || dfs(board, word, row, col + 1, position + 1) || dfs(board, word, row - 1, col, position + 1) || dfs(board, word, row, col -1, position + 1)) {
             return true;
        }
        board[row][col] = word.charAt(position);
        return false;
    }
}