class Solution {
    private int[] candidates;
    private int target;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(0, res, cur, 0);
        return res;
    }
    
    private void dfs(int i, List<List<Integer>> res, List<Integer> cur, int total) {  // Fixed syntax here
        // Base cases
        if (total == target) {
            res.add(new ArrayList<>(cur));  // Create a new copy of cur
            return;
        }
        if (i >= candidates.length || total > target) {
            return;
        }
        
        // Include current number
        cur.add(candidates[i]);
        dfs(i, res, cur, total + candidates[i]);
        cur.remove(cur.size() - 1);  // Backtrack
        
        // Skip current number
        dfs(i + 1, res, cur, total);
    }
}