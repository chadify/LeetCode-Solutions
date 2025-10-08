class Solution {
    static int totalSum;
    static int[] prefix; // prefix[i] = sum(nums[0..i])
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        // Reset static state for each run
        totalSum = 0;
        for (int x : nums) totalSum += x;

        // Build prefix sums for tight pruning |target| <= sum(nums[0..i])
        prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) prefix[i] = prefix[i - 1] + nums[i];

        // DP table over (i, targetShift) where targetShift = totalSum + target
        int m = 2 * totalSum + 1;          // valid shifts: [0 .. 2*totalSum]
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        return helper(nums, target, n - 1, dp);
    }

    static int helper(int[] nums, int target, int i, int[][] dp) {
        // Prune: with only nums[0..i], max reachable absolute sum is prefix[i]
        if (Math.abs(target) > prefix[i]) return 0;

        // Base case: decide sign for the very first number nums[0]
        if (i == 0) {
            if (target == 0 && nums[0] == 0) return 2;               // +0 and -0
            if (nums[0] == target || -nums[0] == target) return 1;   // either + or -
            return 0;
        }

        // Shift target into [0 .. 2*totalSum] and guard bounds
        int shift = totalSum + target;
        if (shift < 0 || shift >= dp[0].length) return 0;

        // Memo
        if (dp[i][shift] != -1) return dp[i][shift];

        // Recurse: choose sign for nums[i]
        int withPlus  = helper(nums, target - nums[i], i - 1, dp); // put +nums[i] → target decreases
        int withMinus = helper(nums, target + nums[i], i - 1, dp); // put -nums[i] → target increases

        return dp[i][shift] = withPlus + withMinus;
    }
}