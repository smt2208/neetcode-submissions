class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        
        for (String s : strs) {
            // Append length, then delimiter, then the string itself
            encodedString.append(s.length()).append('#').append(s);
        }
        
        return encodedString.toString();
    }

    public List<String> decode(String str) {
        List<String> decodedStrings = new ArrayList<>();
        int i = 0; // Main pointer iterating through the whole encoded string
        
        while (i < str.length()) {
            int j = i;
            // Move j forward until we find our delimiter
            while (str.charAt(j) != '#') {
                j++;
            }
            
            // Extract the length number
            int length = Integer.parseInt(str.substring(i, j));
            
            // The actual string starts immediately after the '#'
            int stringStart = j + 1;
            
            // Extract the actual string using the length we found
            String s = str.substring(stringStart, stringStart + length);
            decodedStrings.add(s);
            
            // Move our main pointer i to the start of the next encoded chunk
            i = stringStart + length;
        }
        
        return decodedStrings;
    }
}
