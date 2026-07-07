//without using using Boye-Moore vot alogorithm
class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            // If the count is 0, we assume the current number is the new majority candidate
            if (count == 0) {
                candidate = num;
            }

            // If it matches our candidate, increment count. Otherwise, decrement.
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // The surviving candidate is our majority element
        return candidate;
    }
}