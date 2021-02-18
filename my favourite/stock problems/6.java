class Solution {
    public int maxProfit(int[] prices, int fee) {
        int i0 = 0, i1 = -100001;
        
        for (int price : prices) {
            int old_i0 = i0;
            i0 = Math.max(i0, i1 + price - fee);
            i1 = Math.max(i1, old_i0 - price);
        }
        return i0;
    }
}