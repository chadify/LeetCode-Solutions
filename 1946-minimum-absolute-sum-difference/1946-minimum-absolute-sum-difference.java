import java.util.Arrays;

class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int MOD = 1_000_000_007;
        int n = nums1.length;
        int[] sortedNums1 = nums1.clone();
        Arrays.sort(sortedNums1);

        int originalSum = 0;
        int maxImprovement = 0;

        for (int i = 0; i < n; i++) {
            int currentDiff = Math.abs(nums1[i] - nums2[i]);
            originalSum = (originalSum + currentDiff) % MOD;

            // Binary search to find the closest element in sortedNums1 to nums2[i]
            int closestIndex = binarySearchClosest(sortedNums1, nums2[i]);
            int improvedDiff = Math.abs(sortedNums1[closestIndex] - nums2[i]);
            maxImprovement = Math.max(maxImprovement, currentDiff - improvedDiff);
        }

        return (originalSum - maxImprovement + MOD) % MOD;
    }

    // Binary search to find the closest value to target in sortedNums1
    private int binarySearchClosest(int[] sortedNums1, int target) {
        int low = 0, high = sortedNums1.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (sortedNums1[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        // Check the closest between `low` and `low - 1` if applicable
        if (low > 0 && Math.abs(sortedNums1[low - 1] - target) < Math.abs(sortedNums1[low] - target)) {
            return low - 1;
        }
        return low;
    }
}