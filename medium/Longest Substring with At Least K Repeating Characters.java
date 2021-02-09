class Solution {
    public int longestSubstring(String s, int k) {
        int maxUnique = getMaxUniqueLetters(s);
        char[] str = s.toCharArray();
        int max = 0;
        int[] countMap = new int[26];
        for (int curUnique=1;curUnique<=maxUnique;++curUnique) {
            // reset countMap
            Arrays.fill(countMap, 0);
            int windowStart = 0, windowEnd = 0, idx = 0, unique = 0, countAtLeastK = 0;
            
            while (windowEnd < str.length) {
                if (unique <= curUnique) {
                    idx = str[windowEnd] - 'a';
                    if (countMap[idx] == 0) unique++;
                    countMap[idx]++;
                    if (countMap[idx] == k) countAtLeastK++;
                    windowEnd++;
                } else {
                    idx = str[windowStart] - 'a';
                    if (countMap[idx] == 1) unique--;
                    if (countMap[idx] == k) countAtLeastK--;
                    countMap[idx]--;
                    windowStart++;
                }
                
                if (unique == curUnique && countAtLeastK == unique) {
                    max = Math.max(max, windowEnd - windowStart);
                }
            }
        }
        
        return max;
    }
    
    public int getMaxUniqueLetters(String s) {
        boolean map[] = new boolean[26];
        int maxUnique = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map[s.charAt(i) - 'a']) {
                maxUnique++;
                map[s.charAt(i) - 'a'] = true;
            }
        }
        return maxUnique;
    }
}