class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxf = 0;
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            // Add the current character to our window's count
            char c = s.charAt(right);
            count[c - 'A']++;
            
            // Update the count of the most frequent character in the current window
            maxf = Math.max(maxf, count[c - 'A']);

            // The number of characters we need to replace is the window size minus 
            // the frequency of the most frequent character.
            // If this exceeds k, our window is invalid, and we must shrink it from the left.
            if ((right - left + 1) - maxf > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            // Update the maximum length found so far
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}