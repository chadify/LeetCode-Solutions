// Alternative solution using Stack (closer to your original approach)
class Solution {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder word = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c != ' ') {
                word.append(c);
            } else if (word.length() > 0) {
                // Found end of word, push to stack
                stack.push(word.toString());
                word.setLength(0); // Clear the StringBuilder
            }
        }
        
        // Don't forget the last word if string doesn't end with space
        if (word.length() > 0) {
            stack.push(word.toString());
        }
        
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
            if (!stack.isEmpty()) {  // Don't add space after the last word
                res.append(" ");
            }
        }
        
        return res.toString();
    }
}