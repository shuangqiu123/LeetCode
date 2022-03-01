// leetcode 200
class Solution {
    public int numIslands(char[][] grid) {
        int num = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    dfsRemove1s(i, j, grid);
                }
            }
        }
        
        return num;
    }
    
    private void dfsRemove1s(int row, int col, char[][] grid) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }
        if (grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        
        dfsRemove1s(row + 1, col, grid);
        dfsRemove1s(row - 1, col, grid);     
        dfsRemove1s(row, col + 1, grid);
        dfsRemove1s(row, col - 1, grid);
    }
}