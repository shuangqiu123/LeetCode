// leetcode 494
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        
        for (int num : nums) {
            sum += num;
        }

        if (sum < target || (target + sum) % 2 != 0) {
            return 0;
        }
        
        int newTarget = (target + sum) / 2;
        
        if (newTarget < 0) {
            newTarget = (sum - target) / 2;
        }
        
        int[] dp = new int[newTarget + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int i = newTarget; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        
        return dp[newTarget];
    }
}