class Solution {
    public int[] sortArray(int[] nums) {
        if(nums==null||nums.length<=1)
        return nums;

        mergesort(nums,0,nums.length-1);
        return nums;
    }
    private void mergesort(int nums[],int left,int right)
    {
        if(left<right)
        {
            int mid=left+(right-left)/2;
            //Recursively sort the first and second halves
            mergesort(nums,left,mid);
            mergesort(nums,mid+1,right);


            //merge the sorted halves
            merge(nums,left,mid,right);
        }
    }
    private void merge(int[] nums, int left, int mid, int right) {
        // Find sizes of the two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; ++i)
            L[i] = nums[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = nums[mid + 1 + j];

        // Merge the temporary arrays back into nums
        int i = 0, j = 0;
        int k = left; // Initial index of merged subarray

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                nums[k] = L[i];
                i++;
            } else {
                nums[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            nums[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            nums[k] = R[j];
            j++;
            k++;
        }
    }

}