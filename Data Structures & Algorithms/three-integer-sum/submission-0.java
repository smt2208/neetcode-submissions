public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Set to store unique sorted triplets and avoid duplicates
        Set<List<Integer>> uniqueTriplets = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int target = -nums[i];
            Set<Integer> s = new HashSet<>();

            for (int j = i + 1; j < n; j++) {
                int third = target - nums[j];

                // If the required third element exists in our set
                if (s.contains(third)) {
                    List<Integer> trip = Arrays.asList(nums[i], nums[j], third);
                    
                    // Sort the triplet so the HashSet can uniquely identify duplicates
                    trip.sort(null); 
                    uniqueTriplets.add(trip);
                }
                
                // Track the current element for future pairs
                s.add(nums[j]);
            }
        }

        // Convert the set of unique triplets back to the required List format
        return new ArrayList<>(uniqueTriplets);
    }
}