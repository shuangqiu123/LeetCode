/**
classic backtracking problem
 */
class Solution {
    int index = 0;
    String decodeString(String s) {
        return decode(s).toString();
    }
    
    StringBuilder decode(String s) {
        StringBuilder sb = new StringBuilder();
        
        while (index < s.length() && s.charAt(index) != ']') {
            char c = s.charAt(index);
            if (Character.isAlphabetic(c)) {
                sb.append(c);
                index++;
            } else {
                int num = 0;
                // check for num >= 10 
                while (Character.isDigit(c)) {
                    num = num * 10 + (c-'0');
                    c = s.charAt(++index);
                }
                index++;
                StringBuilder bracket = decode(s);
                index++;
                for (int i=0;i<num;++i) sb.append(bracket);
            }
        }
        
        return sb;
    }
}
