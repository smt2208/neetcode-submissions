
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. Map to count the frequencies of each number
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        // 2. Create a Min-Heap based on frequency
        // (a, b) -> countMap.get(a) - countMap.get(b) tells the queue to sort by values in the map
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a, b) -> countMap.get(a) - countMap.get(b)
        );
        
        // 3. Keep only the top k elements in the heap
        for (int key : countMap.keySet()) {
            minHeap.add(key);
            
            // If the heap grows beyond size k, drop the least frequent element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        // 4. Extract the k remaining elements into our result array
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll();
        }
        
        return res;
    }
}