class Solution {

    public int subsetXORSum(int[] nums) {
        return solve(nums, 0, 0);
    }

    private int solve(int[] nums, int index, int xor) {

        // Base Case
        if (index == nums.length) {
            return xor;
        }

        // Include current element
        int take = solve(nums, index + 1, xor ^ nums[index]);

        // Exclude current element
        int notTake = solve(nums, index + 1, xor);

        return take + notTake;
    }
}