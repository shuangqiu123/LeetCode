// recurrence relation
// i -- date
// k -- the number of times of transaction (buying)
// 0/1 -- hold or not hold the stock
// T[i][k][0] = max (T[i-1][k][0], T[i-1][k][1] + price[i]);
// T[i][k][1] = max (T[i-1][k][1], T[i-1][k-1][1] - price[i]);
// initially, T[-1][k][0] = 0, T[-1][k][1] = Min_Value
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int i_10 = 0, i_11 = Integer.MIN_VALUE, i_00=0;
        
        for (int price : prices) {
            i_10 = Math.max(i_10,i_11 + price);
            i_11 = Math.max(i_11, -price);
        }
        
        return i_10;
    }
}