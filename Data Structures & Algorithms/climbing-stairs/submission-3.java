//Tabulation
class Solution {
    public int climbStairs(int n) {
        // Base cases
        if (n == 1) return 1;
        if (n == 2) return 2;

        // Create DP table
        int[] dp = new int[n + 1];

        // Initialize known base states
        dp[1] = 1;
        dp[2] = 2;

        // Fill the table iteratively
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}

