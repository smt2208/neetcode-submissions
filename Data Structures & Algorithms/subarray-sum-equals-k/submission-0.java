public class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;     // Stores the total count of valid subarrays found
        int curSum = 0;  // Stores the running prefix sum from index 0 to the current element

        // Key: Prefix Sum | Value: Number of times this prefix sum has occurred
        Map<Integer, Integer> prefixSums = new HashMap<>();

        // Base Case: A prefix sum of 0 has occurred 1 time (before starting the array).
        // This handles subarrays starting at index 0 that sum up to k directly (curSum - k = 0).
        prefixSums.put(0, 1);

        for (int num : nums) {
            // 1. Add current number to running prefix sum
            curSum += num;

            // 2. Determine what prefix sum we needed to see previously:
            //    SubarraySum = (currentPrefixSum - previousPrefixSum) = k
            //    Rearranging gives: previousPrefixSum = curSum - k
            int diff = curSum - k;

            // 3. If 'diff' was seen before, each occurrence represents a valid subarray ending here
            res += prefixSums.getOrDefault(diff, 0);

            // 4. Store/update the count of the current prefix sum in the HashMap for future elements
            prefixSums.put(curSum, prefixSums.getOrDefault(curSum, 0) + 1);
        }

        return res;
    }
}