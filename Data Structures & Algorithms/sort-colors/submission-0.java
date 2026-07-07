class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        
        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap mid and low
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // Already in the right place
                mid++;
            } else { // nums[mid] == 2
                // Swap mid and high
                swap(nums, mid, high);
                high--;
                // Note: We do NOT increment mid here!
            }
        }
    }
    
    // Helper method to keep code clean
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}