import java.util.*;

class Program {
  public static int palindromePartitioningMinCuts(String str) {
		int length = str.length();
    boolean[][] dp = new boolean[length][length];
		int[] mincuts = new int[length];
		
		for (int i = 0; i < length; i++) {
			for (int j = 0; j <= i; j++) {
				if (str.charAt(i) == str.charAt(j)) {
					if (i - j <= 2) {
						dp[j][i] = true;
					}
					else {
						dp[j][i] = dp[j + 1][i - 1];
					}
				}
			}
		}
		
		Arrays.fill(mincuts, length);
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (dp[i][j]) {
					if (i == 0) {
						mincuts[j] = 0;
					}
					else {
						mincuts[j] = Math.min(mincuts[j], mincuts[i - 1] + 1);
					}
				}
			}
		}
		
    return mincuts[length - 1];
  }
}
