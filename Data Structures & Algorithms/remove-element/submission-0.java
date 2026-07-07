class Solution {
public int removeElement(int[] nums, int val) {
        int k = 0; // The writer pointer
        
        // i is the reader pointer
        for (int i = 0; i < nums.length; i++) {
            
            // If we find a number that we want to keep...
            if (nums[i] != val) {
                // ...put it at the 'k' index and increment 'k'
                nums[k] = nums[i];
                k++;
            }
        }
        
        // k now represents the total count of numbers kept
        return k;
    }
}