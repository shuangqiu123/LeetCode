class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        
        String s = countAndSay(n-1);
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i=0;i<s.length()-1;++i) {
            if (s.charAt(i) == s.charAt(i+1)) {
                count++;
            } else {
                sb.append(count);
                sb.append(s.charAt(i));
                count = 1;
            }
        }
        sb.append(count);
        sb.append(s.charAt(s.length()-1));

        return sb.toString();
    }
}