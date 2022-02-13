// leetcode 96
class Solution {
    public int numTrees(int n) {
        if (n < 3) return n;
        int[] cache = new int[n + 1];
        cache[0] = 1;
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            int value = 0;
            for (int j = 0; j < i; j++) {
                int left = j;
                int right = i - j - 1;
                value += cache[left] * cache[right];
            }
            cache[i] = value;
        }
        
        return cache[n];
    }
}