class Solution {
        public static int minLength(String s) {

        // Copy the string to a StringBuilder
        StringBuilder str = new StringBuilder(s);

        // Iterate over the StringBuilder
        for (int i = 0; i < str.length() - 1; i++) { // Ensure i+1 is within bounds
            if (str.charAt(i) == 'A' && str.charAt(i + 1) == 'B') {
                str.delete(i, i + 2); // Remove both 'A' and 'B'
                if (i != 0) {
                    i -= 2; // Adjust index to re-check from the previous character
                }
                else
                    i--;
            } else if (str.charAt(i) == 'C' && str.charAt(i + 1) == 'D') {
                str.delete(i, i + 2); // Remove both 'C' and 'D'
                if (i != 0) {
                    i -= 2; // Adjust index to re-check from the previous character
                }
                else
                    i--;
            }
        }

        return str.length();
    }
}