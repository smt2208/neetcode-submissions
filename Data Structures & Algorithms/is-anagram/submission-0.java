class Solution {
    public boolean isAnagram(String s, String t) {
        // Base case: If lengths differ, they can't be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Array to hold frequencies of the 26 lowercase English letters
        int[] counts = new int[26];

        // Build the frequency map
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++; // Add 1 for string s
            counts[t.charAt(i) - 'a']--; // Subtract 1 for string t
        }

        // Check if all counts balanced out to 0
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
