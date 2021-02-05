class Solution {
    public int trailingZeroes(int n) {
        int count = 0;

        // 10 is a product of 2 and 5, but 2 appears more than 5
        while (n != 0) {

            // count how many fives in n
            int tmp = n / 5;
            count += tmp;

            // special case for 25, 125, 625 etc...
            n = tmp;
        }
        return count;
    }
}