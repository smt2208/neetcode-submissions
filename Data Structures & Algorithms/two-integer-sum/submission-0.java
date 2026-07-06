
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // If the map has the complement, we found our pair!
            if (map.containsKey(complement)) {
                // Return a brand new primitive int array directly
                return new int[] { map.get(complement), i };
            }
            
            // Otherwise, store the current number and its index
            map.put(nums[i], i);
        }
        
        // Fallback return if no solution is found 
        // (The problem guarantees one exists, so this is just to satisfy Java)
        return new int[] {}; 
    }
}