class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix[0].length,m=matrix.length;
        int[][] dp = new int[m][n];
        int size = 0;
        for (int i=0;i<m;++i) {
            for (int j=0;j<n;++j) {
                // if matrix is 0, then it cant be a square
                if (matrix[i][j] == '0') 
                    dp[i][j] = 0;
                else if (i==0 || j==0)
                    dp[i][j] = 1;
                else {

                    // all three surrounding has to be greater than 1 to update
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }
                size = Math.max(size, dp[i][j]);
            }
        }
        
        return size * size;
    }
}