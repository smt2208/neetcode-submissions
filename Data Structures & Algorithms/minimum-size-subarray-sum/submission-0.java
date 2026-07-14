class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int currentSum = 0;
        int left = 0;
        
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];
            
            // Once the sum is valid, try shrinking the window from the left
            while (currentSum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                currentSum -= nums[left];
                left++;
            }
        }
        
        // If minLen was never updated, no valid subarray was found
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}