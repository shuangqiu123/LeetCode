class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int i=0,j=0;
        int maxlen = 0;
        HashSet<Character> set = new HashSet<>();
        
        while (i<len && j<len) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
            } else {
                set.add(s.charAt(j++));
                maxlen = Math.max(maxlen,j-i);
            }
        }
        
        return maxlen;
    }
}