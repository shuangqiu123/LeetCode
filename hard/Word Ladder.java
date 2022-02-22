// leetcode 127
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int length = 1;
        ArrayDeque<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            length++;
            for (int i = 0; i < queueSize; i++) {
                String w = queue.poll();
                for (String word : wordList) {
                    if (visited.contains(word)) {
                        continue;
                    }
                    if (differOnlyOneLetter(w, word)) {
                        if (endWord.equals(word)) {
                            return length;
                        }
                        queue.add(word);
                        visited.add(word);
                    }
                }
            }
        }
        return 0;
    }
    
    private boolean differOnlyOneLetter(String w1, String w2) {
        int diff = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                diff++;
            }
        }
        
        return diff == 1;
    }
}

/*
hit

while (queue not empty) {
    first word = hit
    
    

}

*/