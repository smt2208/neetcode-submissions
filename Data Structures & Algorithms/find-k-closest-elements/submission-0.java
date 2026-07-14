class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;
        
        // We want to shrink our window until exactly 'k' elements remain.
        // The number of elements between left and right is (right - left + 1).
        // So we keep shrinking as long as (right - left + 1) > k, 
        // which simplifies to (right - left >= k).
        while (right - left >= k) {
            
            // Compare the distances of the edge elements to the target 'x'
            int distLeft = Math.abs(x - arr[left]);
            int distRight = Math.abs(x - arr[right]);
            
            if (distLeft <= distRight) {
                // The right element is further away (or they are tied).
                // If tied, we prefer the smaller value (the left one).
                // So, we toss out the right element.
                right--; 
            } else {
                // The left element is further away, so we toss it out.
                left++;
            }
        }
        
        // Collect the surviving 'k' elements
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }
        
        return result;
    }
}