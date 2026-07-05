
class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            // If the set already has the number, it's a duplicate
            if (seen.contains(num)) {
                return true; 
            }
            // Otherwise, add it to our set to keep track of it
            seen.add(num);
        }
        
        // If we finish the loop, all elements were unique
        return false;
    }
}