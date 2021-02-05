class Solution {

    // pointer solution O(mn) worse
    // "*b"  "abbbbbbbbbc"
    public boolean isMatch(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;            
        
        while (s < str.length()) {
            // increase two pointers
            if (p < pattern.length() && (str.charAt(s) == pattern.charAt(p) || pattern.charAt(p)=='?')) {
                s++;
                p++;
            }
            
            else if (p < pattern.length() && pattern.charAt(p)=='*') {
                starIdx = p;
                match = s;
                p++;
            }
            
            // go back to the starting point, increase the match index by 1
            else if (starIdx != -1) {
                p = starIdx + 1;
                match++;
                s = match;
            }
            
            else {
                return false;
            }
        }
        
        // check if there is any trailing *
        while (p < pattern.length() && pattern.charAt(p) == '*') ++p;
        
        return p == pattern.length();
    }


    // dp
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i=1;i<=m;++i) {
            if (p.charAt(i-1)=='*') {
                dp[i][0] = dp[i-1][0];
            }
        }
        
        for (int i=1;i<=m;++i) {
            for (int j=1;j<=n;++j) {
                if (p.charAt(i-1)=='*' && dp[i-1][j-1]) {
                    for (int k=j;k<=n;++k) dp[i][k] = true;
                    break;
                }
                else if (p.charAt(i-1)=='*' && dp[i-1][j]) {
                    dp[i][j] = true;
                }
                else if (p.charAt(i-1)=='?' || p.charAt(i-1)==s.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[m][n];
    }
}