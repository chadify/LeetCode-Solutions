class Solution {
    private int[] nums;
    private int target;
    private int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        helper(0, 0);
        return count;
    }

    private void helper(int i, int sum) {
        if (i == nums.length && sum == target) {
            count++;
            return;
        }
        if (i == nums.length)
            return;
        helper(i+1, sum + nums[i]);
        helper(i+1, sum - nums[i]);
    }
}