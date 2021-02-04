class Solution {
    public String alienOrder(String[] words) {
        if (words.length == 1) return words[0];
        HashMap<Character,HashSet<Character>> map = new HashMap<>();
        Map<Character, Integer> degree=new HashMap<Character, Integer>();
        
        for(String s: words){
            for(char c: s.toCharArray()){
                degree.put(c,0);
            }
        }
        
        // step1: build the adjacent list
        for (int j=0;j<words.length-1;++j) {
            String word1 = words[j], word2 = words[j+1];
            int i = 0, min = Math.min(word1.length(),word2.length());
            for (i=0;i< min;++i) {
                if (word1.charAt(i) != word2.charAt(i)) {
                    if (!map.containsKey(word1.charAt(i))) {
                        map.put(word1.charAt(i), new HashSet<>());
                    }
                    if (!map.get(word1.charAt(i)).contains(word2.charAt(i))) {
                                            map.get(word1.charAt(i)).add(word2.charAt(i));
                    degree.put(word2.charAt(i), degree.getOrDefault(word2.charAt(i),0)+1);
                    }
                    break;
                }
            }
            
            if (i == min && word1.length() > word2.length()) return "";
        }
        
        //step3: queue for nodes
        ArrayDeque<Character> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        
        for (char c : degree.keySet()) {
            if (degree.get(c) == 0) queue.add(c);
        }
        
        //step4: topological ordering
        while (!queue.isEmpty()) {
            char c = queue.pollFirst();
            degree.remove(c);
            sb.append(c);
            
            if (!map.containsKey(c)) continue;     
            for (char ch : map.get(c)) {
                degree.put(ch, degree.get(ch)-1);
                if (degree.get(ch) == 0) queue.add(ch);
            }  
        }
        
        if (degree.size() > 0) return "";
        
        return sb.toString();
        
    }
}