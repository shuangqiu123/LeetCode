class Solution {
    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 16) {
            return new ArrayList<>();
        }
        return generateIp(s, 4);
    }
    
    public List<String> generateIp(String s, int n) {
        if (s.length() < n || s.length() > n * 4) {
            return null;
        }
        List<String> result = new ArrayList<>();

        if (n == 1) {
            // 1.0.1.023
            if ((s.length() > 1 && s.charAt(0) == '0') || Integer.parseInt(s) > 255) {
                return null;
            }
            else {
              // [23]
                result.add(s);
                return result;
            }
        }

        int value = 0;
        for (int i = 0; i < s.length(); i++) {
            value = value * 10 + (s.charAt(i) - '0');

            if (value > 255) {
                break;
            }

            List<String> strs = generateIp(s.substring(i + 1), n - 1);
            // [10.2.23]  
          
            //"101023"
            if (strs != null) {
                for (String str : strs) {
                    result.add(value + "." + str);
                }
            }

            // 023.0.0.1
            if (value == 0) {
                break;
            }
        }

        return result;
    }
}