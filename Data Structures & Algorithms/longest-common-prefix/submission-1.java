
class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Sort the array alphabetically
        Arrays.sort(strs);
        
        // Grab the first and last strings after sorting
        String first = strs[0];
        String last = strs[strs.length - 1];
        
        int i = 0;
        // Compare characters until we hit a mismatch or the end of a string
        while (i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)) {
            i++;
        }
        
        // Return the substring of the matching characters
        return first.substring(0, i);
    }
}