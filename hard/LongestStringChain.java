// https://www.algoexpert.io/questions/Longest%20String%20Chain
import java.util.*;

class Program {
  public static List<String> longestStringChain(List<String> strings) {
    Collections.sort(strings, (s1, s2) -> s2.length() - s1.length());
		// System.out.println(strings);
    Map<String, List<String>> cache = new HashMap<>();
		List<String> longestStringChain = new ArrayList<>();
		
		for (int i = 0; i < strings.size(); i++) {
			List<String> stringChain = findLongestStringChain(strings, cache, i);
			if (stringChain.size() > longestStringChain.size()) {
				longestStringChain = stringChain;
			}
		}
		
		return longestStringChain.size() == 1 ? new ArrayList<>() : longestStringChain;
  }
	
	private static List<String> findLongestStringChain(List<String> strings, Map<String, List<String>> cache, int index) {
		
		if (cache.containsKey(strings.get(index))) {
			return cache.get(strings.get(index));
		}
		String s = strings.get(index);
		int length = s.length();
		List<String> longestStringChain = new ArrayList<>();
		
		for (int i = index + 1; i < strings.size(); i++) {
			if (strings.get(i).length() == length) {
				continue;
			}
			if (length - strings.get(i).length() > 1) {
				break;
			}
			if (isValidString(s, strings.get(i))) {
				List<String> list = findLongestStringChain(strings, cache, i);
				if (list.size() > longestStringChain.size()) {
					longestStringChain = list;
				}
			}
		}
		longestStringChain.add(0, s);
		longestStringChain = new ArrayList<>(longestStringChain);

		cache.put(s, longestStringChain);
		
		return longestStringChain;
  }
	
	// O (m)
	private static boolean isValidString(String current, String next) {
		int letterDifference = 0;
		int i = 0;
		int j = 0;

		while (i < current.length() && j < next.length()) {
			if (current.charAt(i) != next.charAt(j)) {
				letterDifference++;
			}
			else {
				j++;
			}
			i++;
		}
		
		return letterDifference <= 1;
	}
}

/*

for the current string,
1. find the set of next valid strings
2. recursively call the same function of those strings to find the string chain
3. find the maximum string chain

cache the result

*/