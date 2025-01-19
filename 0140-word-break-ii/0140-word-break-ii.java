class Solution {
    private List<String> cur = new ArrayList<>();
    private List<String> res = new ArrayList<>();
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        // Clear the result list before starting new calculation
        res.clear();  // Add this line to reset results
        return backtrack(s, wordDict, 0);
    }
    
    private List<String> backtrack(String s, List<String> wordDict, int i) {
        // Base case: if we've reached the end of the string
        if (i == s.length()) {
            String sentence = String.join(" ", cur);
            res.add(sentence);
            return res;
        }
        
        // Try all possible words from current position
        for (int j = i + 1; j <= s.length(); j++) {
            String word = s.substring(i, j);
            if (wordDict.contains(word)) {
                cur.add(word);
                backtrack(s, wordDict, j);
                cur.remove(cur.size() - 1);  // Changed to remove last element
            }
        }
        
        return res;
    }
}