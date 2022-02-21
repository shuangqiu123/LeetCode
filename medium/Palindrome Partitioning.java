// leetcode 131
class Solution {
    
    public List<List<String>> partition(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        List<List<String>> partitions = new ArrayList<>();
        Map<Integer, List<List<String>>> cache = new HashMap<>();
        
        for (int j = 0; j < length; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                    }
                    else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                else {
                    dp[i][j] = false;
                }
            }
        }
        return findPartitions(dp, s, 0, cache);
    }
    
    private List<List<String>> findPartitions(boolean[][] dp, String s, int start, Map<Integer, List<List<String>>> cache) {
        if (start == s.length()) {
            return List.of(new ArrayList<>()); // [[""]]
        }
        
        if (cache.containsKey(start)) {
            return cache.get(start);
        }
        
        List<List<String>> partitions = new ArrayList<>();
        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]) {
                // start = 0, i = 0
                String substring = s.substring(start, i + 1); // "a"
                List<List<String>> list = findPartitions(dp, s, i + 1, cache); // [[""]]
                for (List<String> l : list) {
                    ArrayDeque<String> newL = new ArrayDeque<>(l); // [""]
                    newL.addFirst(substring); // 
                    partitions.add(new ArrayList<>(newL));
                }
            }
        }
        cache.put(start, partitions);
        return partitions;
    }
}