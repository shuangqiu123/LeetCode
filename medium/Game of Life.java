class Solution {
    // mark the change in different number
    public void gameOfLife(int[][] board) {
        int m = board.length;
        if (m==0) return;
        int n = board[0].length;
        
        for (int i=0;i<m;++i) {
            for (int j=0;j<n;++j) {
                if (board[i][j]==-1 || board[i][j]==2) continue;
                
                int liveNums = 0;
                for (int k=Math.max(0,i-1);k<Math.min(m,i+2);++k) {
                    for (int o=Math.max(0,j-1);o<Math.min(n,j+2);++o) {
                        if (board[k][o]==1 || board[k][o]==2) liveNums++;
                    }
                }
                
                if (board[i][j]==1) {
                    if (liveNums < 3 || liveNums > 4)  board[i][j]=2;
                } else {
                    if (liveNums==3) board[i][j] = -1;
                }
            }
        }
        
        for (int i=0;i<m;++i) {
            for (int j=0;j<n;++j) {
                if (board[i][j]==-1) board[i][j]=1;
                else if (board[i][j]==2) board[i][j]=0;
            }
        }
    }
}