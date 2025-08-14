class Solution {
    public String removeOuterParentheses(String s) {
       // "" , "(" + A + ")", or A + B
       // primitive string : (), (((A + B))), so enclosed by brackets entirely, therefore can't be separated
       // Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.
       // (()())(()) : (A+B) + (C)
       // read, c

        StringBuilder res = new StringBuilder();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' && count++ > 0) {
                res.append(s.charAt(i));
            }
            if (s.charAt(i) == ')' && count-- > 1) {
                res.append(s.charAt(i));
            }
        }

        return res.toString();
    }
}