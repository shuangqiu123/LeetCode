class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int current = 0;
        List<String> result = new ArrayList<>();
        
        while (current < words.length) {
            int right = findRight(current, words, maxWidth);
            String s = justify(current, right, words, maxWidth);
            result.add(s);
            
            current = right + 1;
        }
        
        return result;
    }
    
    
    public int findRight(int current, String[] words, int maxWidth) {
        int right = current;
        int sum = words[right++].length();
        
        while (right < words.length && sum + words[right].length() + 1 <= maxWidth) {
            sum += words[right++].length() + 1;
        }
        
        return right - 1;
    }
    
    
 private String justify(int left, int right, String[] words, int maxWidth) {
        if (right - left == 0) return padResult(words[left], maxWidth);
        
        boolean isLastLine = right == words.length - 1;
        int numSpaces = right - left;
        int totalSpace = maxWidth - wordsLength(left, right, words);
        
        String space = isLastLine ? " " : blank(totalSpace / numSpaces);
        int remainder = isLastLine ? 0 : totalSpace % numSpaces;
        
        StringBuilder result = new StringBuilder();
        for (int i = left; i <= right; i++)
            result.append(words[i])
                .append(space)
                .append(remainder-- > 0 ? " " : "");
        
        return padResult(result.toString().trim(), maxWidth);
    }
    
    private int wordsLength(int left, int right, String[] words) {
        int wordsLength = 0;
        for (int i = left; i <= right; i++) wordsLength += words[i].length();
        return wordsLength;
    }
    
    private String padResult(String result, int maxWidth) {
        return result + blank(maxWidth - result.length());
    }
    
    private String blank(int length) {
        return new String(new char[length]).replace('\0', ' ');
    }
}