
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Edge case: s1 cannot be longer than s2
        if (s1.length() > s2.length()) {
            return false;
        }
        
        // Frequency arrays for the 26 lowercase English letters
        int[] s1Count = new int[26];
        int[] windowCount = new int[26];
        
        // 1. Populate the target frequency map for s1
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
        }
        
        int left = 0; // Left boundary of our sliding window
        
        // 2. Slide the window across s2
        for (int right = 0; right < s2.length(); right++) {
            
            // Add the current character on the right to our window's frequency map
            windowCount[s2.charAt(right) - 'a']++;
            
            // 3. Maintain the Fixed Window Size
            // If the window grows larger than s1, we must shrink it from the left
            if (right - left + 1 > s1.length()) {
                windowCount[s2.charAt(left) - 'a']--; // Remove left character's count
                left++; // Slide the left boundary forward
            }
            
            // 4. Check for a match
            // If the window is the exact size of s1, compare the frequency arrays
            if (right - left + 1 == s1.length()) {
                if (Arrays.equals(s1Count, windowCount)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}