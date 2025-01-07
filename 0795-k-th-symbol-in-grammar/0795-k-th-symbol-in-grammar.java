class Solution {
    public int kthGrammar(int n, int k) {
        if (n == 1) return 0;
        
        // Find parent's position
        int parent = (k + 1) / 2;
        int parentValue = kthGrammar(n - 1, parent);
        
        // If k is odd, return same as parent
        // If k is even, return opposite of parent
        if (k % 2 == 1) {
            return parentValue;
        } else {
            return 1 - parentValue;
        }
    }
}