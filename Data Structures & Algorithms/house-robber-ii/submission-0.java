class Solution {
    // Helper method: Solves linear House Robber for a specific subarray range
    private static int robLinear(int[] nums, int start, int end) {
        int length = end - start + 1;
        
        if (length == 1) return nums[start];

        int[] dp = new int[length];

        // Base cases
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);

        // Fill table
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
        }

        return dp[length - 1];
    }
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        // Case 1: Rob houses from index 0 to n - 2
        int max1 = robLinear(nums, 0, nums.length - 2);

        // Case 2: Rob houses from index 1 to n - 1
        int max2 = robLinear(nums, 1, nums.length - 1);

        return Math.max(max1, max2);
    }
}
