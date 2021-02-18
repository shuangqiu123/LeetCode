class Solution {
    public int maxProfit(int[] prices) {
        int t_i_0 = 0, t_i_1 = Integer.MIN_VALUE, t_i_pre = 0;
        
        for (int price : prices) {
            int old_ti0 = t_i_0;
            t_i_0 = Math.max(t_i_0, t_i_1 + price);
            t_i_1 = Math.max(t_i_1, t_i_pre - price);
            t_i_pre = old_ti0;
        }
        
        return t_i_0;
    }
}