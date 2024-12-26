class Solution {
    public void reverseString(char[] s) {
        helper(s, 0);
    }

    private static void helper(char[] s, int i) {
        if (i > (s.length - 1)/2)
            return;
        char temp = s[i];
        s[i] = s[s.length - 1 - i];
        s[s.length - 1 - i] = temp;
        i++;

        helper(s, i);
    }
}