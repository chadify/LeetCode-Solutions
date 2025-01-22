class Solution {
    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Set<String> wordDict = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            if (word.length() > 0 && backtrack(word, wordDict, 0, new HashMap<>())) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean backtrack(String s, Set<String> wordDict, int start, Map<Integer, Boolean> memo) {
        // Check if the result for this starting index is already computed
        if (memo.containsKey(start)) {
            return memo.get(start);
        }
        
        // If we have processed the entire string
        if (start == s.length()) {
            return true;
        }

        // Try every possible substring from the current starting position
        for (int end = start + 1; end <= s.length(); end++) {
            String prefix = s.substring(start, end);
            // Ensure the word itself is not used as part of its concatenation
            if (wordDict.contains(prefix) && !prefix.equals(s)) {
                if (backtrack(s, wordDict, end, memo)) {
                    memo.put(start, true);
                    return true;
                }
            }
        }
        
        memo.put(start, false);
        return false;
    }
}