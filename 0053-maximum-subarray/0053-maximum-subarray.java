class Solution {
    public int maxSubArray(int[] nums) {

        int maxsum = Integer.MIN_VALUE;
        int cursum = maxsum;
        for (int num: nums) {
            if (cursum < 0)
                cursum = 0;
            cursum += num;
            maxsum = Math.max(cursum, maxsum);
        }
        return maxsum;
    }
}