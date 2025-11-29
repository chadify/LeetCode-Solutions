class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        // iterate through the array, if 1s encountered
        // simply increase the counter
        // 1, 1, 0, 1, 1, 1

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = 0;
            while (i < nums.length && nums[i] == 1) {
                cur++;
                i++;
            }
            count = Math.max(count, cur);
        }

        return count;
    }
}