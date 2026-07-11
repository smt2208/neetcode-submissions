class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // If characters match, keep moving inward
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                // Mismatch found! 
                // We can either skip the left character OR skip the right character.
                // We use a helper function to check both possibilities.
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
        }
        
        // If we reach here, the string is already a perfect palindrome
        return true; 
    }

    // Helper method to check if a specific substring is a strict palindrome
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}