// leetcode 763
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastApperanceOfLetter = new int[26];
        List<Integer> result = new ArrayList<>();
        int bound = 0;
        int lastBoundIndex = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            lastApperanceOfLetter[c - 'a'] = i;
        }
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            bound = Math.max(bound, lastApperanceOfLetter[c - 'a']);
            
            if (i == bound) {
                result.add(i - lastBoundIndex);
                lastBoundIndex = bound;
            }
        }
        
        return result;
    }
}