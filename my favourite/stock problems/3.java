class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        
        int i10=0,i20=0,i11=Integer.MIN_VALUE,i21=Integer.MIN_VALUE;
        
        for (int price : prices) {
            i20 = Math.max(i20, i21+price);
            i21 = Math.max(i21, i10-price);
            
            i10 = Math.max(i10, i11+price);
            i11 = Math.max(i11, -price);
        }
        
        return i20;
    }
}