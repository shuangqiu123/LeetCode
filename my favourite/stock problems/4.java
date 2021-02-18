class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][] ik = new int[k+1][2];
        
        //initialising variables
        for (int i=0;i<=k;++i) ik[i][1] = Integer.MIN_VALUE;
        
        for (int price : prices) {
            for (int i=k;i>0;--i) {
                ik[i][0] = Math.max(ik[i][0], ik[i][1] + price);
                ik[i][1] = Math.max(ik[i][1], ik[i-1][0] - price);
            }
        }
        
        return ik[k][0];
    }
}