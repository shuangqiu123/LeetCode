public class Solution {
    int count = 0;
    
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        
        for (int i = 0; i < s.length(); i++) { // i is the mid point
            // the odd centered at itself
            extendPalindrome(s,i,i);

            // the even
            extendPalindrome(s,i,i+1);
        }
        
        return count;
    }
    
    private void extendPalindrome(String s, int left, int right) {

        // expand two sides until reach to the border or the chars are different
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
}