public class Solution {
    public String largestOddNumber(String num) {
        // Start from the end and find the rightmost odd digit
        for (int i = num.length() - 1; i >= 0; i--) {
            char digit = num.charAt(i);
            // Check if the digit is odd (1, 3, 5, 7, 9)
            if (digit == '1' || digit == '3' || digit == '5' || 
                digit == '7' || digit == '9') {
                // Return substring from start to this odd digit (inclusive)
                return num.substring(0, i + 1);
            }
        }
        // No odd digit found, return empty string
        return "";
    }
}