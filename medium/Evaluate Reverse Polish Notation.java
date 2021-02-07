class Solution {
        private static final Map<String, BiFunction<Integer, Integer, Integer>> OPERATIONS = new HashMap<>();
    
    // Ensure this only gets done once for ALL test cases.
    static {
        OPERATIONS.put("+", (a, b) -> a + b);
        OPERATIONS.put("-", (a, b) -> a - b);
        OPERATIONS.put("*", (a, b) -> a * b);
        OPERATIONS.put("/", (a, b) -> a / b);
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String str: tokens) {
            if (!OPERATIONS.containsKey(str)) {
                stack.add(Integer.parseInt(str));
            } else {
                BiFunction<Integer, Integer, Integer> opt = OPERATIONS.get(str);
                int i = stack.pop();
                int j = stack.pop();
                int num = opt.apply(j,i);
                stack.add(num);
            }
        }
        
        return stack.pop();
    }
}