public class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int balance = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                // Only add '(' if it's not the outermost opening parenthesis
                if (balance > 0) {
                    result.append(c);
                }
                balance++;
            } else { // c == ')'
                balance--;
                // Only add ')' if it's not the outermost closing parenthesis
                if (balance > 0) {
                    result.append(c);
                }
            }
        }
        
        return result.toString();
    }
}