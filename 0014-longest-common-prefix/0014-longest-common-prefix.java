public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Edge case: empty array
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        // Edge case: single string
        if (strs.length == 1) {
            return strs[0];
        }
        
        // Use the first string as reference
        String firstString = strs[0];
        
        // Check each character position
        for (int i = 0; i < firstString.length(); i++) {
            char currentChar = firstString.charAt(i);
            
            // Compare this character with the same position in all other strings
            for (int j = 1; j < strs.length; j++) {
                // Check if we've reached the end of current string or found a mismatch
                if (i >= strs[j].length() || strs[j].charAt(i) != currentChar) {
                    // Return the prefix up to this point
                    return firstString.substring(0, i);
                }
            }
        }
        
        // If we've checked all characters of the first string without mismatch,
        // the entire first string is the common prefix
        return firstString;
    }
}