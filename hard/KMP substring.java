import java.util.*;

/**
Worst case time complexity == O(m + n)
Space complexity == O(m) where m is the length of the substring
 */
class Program {
  public static boolean knuthMorrisPrattAlgorithm(String string, String substring) {
    int[] pattern = buildPattern(substring);
    return knuthMorrisPrattAlgorithm(string, substring, pattern);
  }
	
	public static int[] buildPattern(String substring) {
		int[] pattern = new int[substring.length()];
		Arrays.fill(pattern, -1);
		int j = 0;
		int i = 1;
		
		while (i < substring.length()) {
			if (substring.charAt(i) == substring.charAt(j)) {
				pattern[i++] = j++;
			}
			else if (j > 0) {
				j = pattern[j - 1] + 1;
			}
			else {
				i++;
			}
		}
		return pattern;
	}
	
	public static boolean knuthMorrisPrattAlgorithm(String string, String substring, int[] pattern) {
		int i = 0;
		int j = 0;
		
		while (i + substring.length() - j <= string.length()) {
			if (substring.charAt(j) == string.charAt(i)) {
				if (j == substring.length() - 1) {
					return true;
				}
				j++;
				i++;
			}
			
			else if (j > 0) {
				j = pattern[j - 1] + 1;
			}
			else {
				i++;
			}
		}
		
		return false;
	}
}
