class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        int j = 0;
        for (int i: nums) {
            strs[j++] = String.valueOf(i);
        }
        
        Comparator<String> cmp = (n,m)->{
            String s1 = n+m;
            String s2 = m+n;
            return s2.compareTo(s1);
        };

        
        Arrays.sort(strs,cmp);
        if (strs[0].charAt(0)=='0') return "0";
        
        StringBuilder sb = new StringBuilder();
        for (String s: strs) {
            sb.append(s);
        }
        return sb.toString();
    }
}