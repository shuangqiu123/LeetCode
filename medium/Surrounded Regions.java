class Solution {
    int m;
    int n;
    public void solve(char[][] board) {
        m = board.length;
        if (m==0) return;
        n = board[0].length;
        
        for (int i=0;i<m;++i) {
            if (board[i][0]=='O') {
                DFS(board,i,0);
            }
            
            if (board[i][n-1]=='O') {
                DFS(board,i,n-1);
            }
        }
        
        for (int i=1;i<n-1;++i) {
            if (board[0][i]=='O') {
                DFS(board,0,i);
            }
            if (board[m-1][i]=='O') {
                DFS(board,m-1,i);
            }
        }
        
        for (int i=0;i<m;++i) {
            for (int j=0;j<n;++j) {
                if (board[i][j]=='O') board[i][j] = 'X';
                else if (board[i][j]=='Y') board[i][j] = 'O';
            }
        }
    }
    
    
    public void DFS(char[][] board, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) return;
        if (board[i][j] == 'X' || board[i][j] == 'Y') return;
        
        board[i][j] = 'Y';
        DFS(board,i+1,j);
        DFS(board,i,j+1);
        DFS(board,i,j-1);
        DFS(board,i-1,j);
    }
}