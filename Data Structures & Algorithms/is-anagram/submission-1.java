class Solution {
    public boolean isAnagram(String s, String t) {
// Base case: If lengths are different, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> charCounts = new HashMap<>();

        // Step 1: Count frequencies of characters in string s
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        // Step 2: Decrement frequencies using string t
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            
            // If character doesn't exist or we've run out of its count
            if (!charCounts.containsKey(c) || charCounts.get(c) == 0) {
                return false;
            }
            
            charCounts.put(c, charCounts.get(c) - 1);
        }

        // If we made it through the loop, the counts match perfectly
        return true;
    }
}
